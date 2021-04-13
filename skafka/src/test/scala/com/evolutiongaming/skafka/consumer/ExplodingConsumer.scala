package com.evolutiongaming.skafka.consumer

import java.lang.{Long => LongJ}
import java.time.{Duration => DurationJ}
import java.util.concurrent.{TimeUnit => TimeUnitJ}
import java.util.regex.Pattern
import java.util.{Collection => CollectionJ, List => ListJ, Map => MapJ, Set => SetJ}

import com.evolutiongaming.skafka.consumer.ExplodingConsumer._
import org.apache.kafka.clients.consumer
import org.apache.kafka.clients.consumer.{
  ConsumerRebalanceListener,
  OffsetAndMetadata,
  OffsetCommitCallback
}
import org.apache.kafka.common.{Metric, MetricName, PartitionInfo, TopicPartition => TopicPartitionJ}

import scala.util.control.NoStackTrace

/**
  * It is intentional to have all methods as `notImplemented` (throws NotImplementedOnPurpose)
  *
  * It is used to verify the only expected interaction in corresponding tests
  * by implementing the only expected method to be called in test
  */
class ExplodingConsumer extends RebalanceConsumerJ {
  def assignment(): SetJ[TopicPartitionJ] = notImplemented

  def subscription(): SetJ[String] = notImplemented

  def subscribe(topics: CollectionJ[String]): Unit = notImplemented

  def subscribe(topics: CollectionJ[String], callback: ConsumerRebalanceListener): Unit = notImplemented

  def assign(partitions: CollectionJ[TopicPartitionJ]): Unit = notImplemented

  def subscribe(pattern: Pattern, callback: ConsumerRebalanceListener): Unit = notImplemented

  def subscribe(pattern: Pattern): Unit = notImplemented

  def unsubscribe(): Unit = notImplemented

  def poll(timeout: LongJ): consumer.ConsumerRecords[String, String] = notImplemented

  def poll(timeout: DurationJ): consumer.ConsumerRecords[String, String] = notImplemented

  def commitSync(): Unit = notImplemented

  def commitSync(timeout: DurationJ): Unit = notImplemented

  def commitSync(offsets: MapJ[TopicPartitionJ, OffsetAndMetadata]): Unit = notImplemented

  def commitSync(offsets: MapJ[TopicPartitionJ, OffsetAndMetadata], timeout: DurationJ): Unit = notImplemented

  def commitAsync(): Unit = notImplemented

  def commitAsync(callback: OffsetCommitCallback): Unit = notImplemented

  def commitAsync(offsets: MapJ[TopicPartitionJ, OffsetAndMetadata], callback: OffsetCommitCallback): Unit = notImplemented

  def seek(partition: TopicPartitionJ, offset: LongJ): Unit = notImplemented

  def seek(partition: TopicPartitionJ, offsetAndMetadata: OffsetAndMetadata): Unit = notImplemented

  def seekToBeginning(partitions: CollectionJ[TopicPartitionJ]): Unit = notImplemented

  def seekToEnd(partitions: CollectionJ[TopicPartitionJ]): Unit = notImplemented

  def position(partition: TopicPartitionJ): LongJ = notImplemented

  def position(partition: TopicPartitionJ, timeout: DurationJ): LongJ = notImplemented

  def committed(partition: TopicPartitionJ): OffsetAndMetadata = notImplemented

  def committed(partition: TopicPartitionJ, timeout: DurationJ): OffsetAndMetadata = notImplemented

  def committed(partitions: SetJ[TopicPartitionJ]): MapJ[TopicPartitionJ, OffsetAndMetadata] = notImplemented

  def committed(
    partitions: SetJ[TopicPartitionJ],
    timeout: DurationJ
  ): MapJ[TopicPartitionJ, OffsetAndMetadata] = notImplemented

  def metrics(): MapJ[MetricName, _ <: Metric] = notImplemented

  def partitionsFor(topic: String): ListJ[PartitionInfo] = notImplemented

  def partitionsFor(topic: String, timeout: DurationJ): ListJ[PartitionInfo] = notImplemented

  def listTopics(): MapJ[String, ListJ[PartitionInfo]] = notImplemented

  def listTopics(timeout: DurationJ): MapJ[String, ListJ[PartitionInfo]] = notImplemented

  def paused(): SetJ[TopicPartitionJ] = notImplemented

  def pause(partitions: CollectionJ[TopicPartitionJ]): Unit = notImplemented

  def resume(partitions: CollectionJ[TopicPartitionJ]): Unit = notImplemented

  def offsetsForTimes(
    timestampsToSearch: MapJ[TopicPartitionJ, LongJ]
  ): MapJ[TopicPartitionJ, consumer.OffsetAndTimestamp] = notImplemented

  def offsetsForTimes(
    timestampsToSearch: MapJ[TopicPartitionJ, LongJ],
    timeout: DurationJ
  ): MapJ[TopicPartitionJ, consumer.OffsetAndTimestamp] = notImplemented

  def beginningOffsets(partitions: CollectionJ[TopicPartitionJ]): MapJ[TopicPartitionJ, LongJ] = notImplemented

  def beginningOffsets(
    partitions: CollectionJ[TopicPartitionJ],
    timeout: DurationJ
  ): MapJ[TopicPartitionJ, LongJ] = notImplemented

  def endOffsets(partitions: CollectionJ[TopicPartitionJ]): MapJ[TopicPartitionJ, LongJ] = notImplemented

  def endOffsets(
    partitions: CollectionJ[TopicPartitionJ],
    timeout: DurationJ
  ): MapJ[TopicPartitionJ, LongJ] = notImplemented

  def groupMetadata(): consumer.ConsumerGroupMetadata = notImplemented

  def close(): Unit = notImplemented

  def close(timeout: Long, unit: TimeUnitJ): Unit = notImplemented

  def close(timeout: DurationJ): Unit = notImplemented

  def wakeup(): Unit = notImplemented
}

object ExplodingConsumer {

  def notImplemented: Nothing = throw NotImplementedOnPurpose

  case object NotImplementedOnPurpose extends NoStackTrace
}
