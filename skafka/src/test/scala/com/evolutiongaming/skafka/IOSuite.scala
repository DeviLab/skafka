package com.evolutiongaming.skafka

import cats.Parallel
import cats.effect.{Clock, Concurrent, ContextShift, IO, Timer}
import com.evolutiongaming.catshelper.{Blocking, FromFuture}
import com.evolutiongaming.smetrics.MeasureDuration
import org.scalatest.Succeeded

import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, Future}

object IOSuite {
  val Timeout: FiniteDuration = 1.minute

  implicit val executor: ExecutionContextExecutor = ExecutionContext.global

  implicit val contextShiftIO: ContextShift[IO]     = IO.contextShift(executor)
  implicit val concurrentIO: Concurrent[IO]         = IO.ioConcurrentEffect
  implicit val timerIO: Timer[IO]                   = IO.timer(executor)
  implicit val parallelIO: Parallel[IO]             = IO.ioParallel
  implicit val fromFutureIO: FromFuture[IO]         = FromFuture.lift[IO]
  implicit val measureDuration: MeasureDuration[IO] = MeasureDuration.fromClock[IO](Clock[IO])
  implicit val blocking: Blocking[IO]               = Blocking.empty[IO]

  def runIO[A](io: IO[A], timeout: FiniteDuration = Timeout): Future[Succeeded.type] = {
    io.timeout(timeout).as(Succeeded).unsafeToFuture()
  }

  implicit class IOOps[A](val self: IO[A]) extends AnyVal {
    def run(timeout: FiniteDuration = Timeout): Future[Succeeded.type] = runIO(self, timeout)
  }
}
