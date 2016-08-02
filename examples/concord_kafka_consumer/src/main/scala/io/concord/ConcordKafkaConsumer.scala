package io.concord;
import java.util.{ HashSet => MutableHashSet}
import io.concord._
import io.concord.swift._
import com.typesafe.scalalogging.LazyLogging
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.TopicPartition
import com.google.common.base.Verify.verify
import com.google.common.base.Preconditions.checkNotNull
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.Properties
import java.util.concurrent.atomic.AtomicInteger

class ConcordKafkaConsumer(
  val broker: String,
  val topic: String,
  val fromBeginning: Boolean) extends Computation with LazyLogging {

  private val topicBytes = topic.getBytes
  private val props = new Properties();
  private val queue = new ConcurrentLinkedQueue[(Array[Byte], Array[Byte])]()
  // Using this instead of queue.size - keep fuzzy count
  // of the size of the queue.
  private var recordCount = new AtomicInteger(0);
  private val thread = new Thread(new Runnable {
    def run() {
      import scala.collection.JavaConversions._
      while(true){
        if(recordCount.get() < 20480){
          val records = consumer.poll(10)
          for (r <- records) {
            queue.offer((r.key, r.value))
            recordCount.addAndGet(1);
          }
        } else {
          Thread.sleep(50);
        }
      }
    }
  })
  props.put("auto.offset.reset",  if(fromBeginning) {
    "earliest"
  } else {
    "latest"
  })
  props.put("bootstrap.servers", broker);
  props.put("group.id", "concord_kafka_source_" + topic + "_concord_group");
  props.put("enable.auto.commit", "true");
  props.put("auto.commit.interval.ms", "1000");
  props.put("session.timeout.ms", "30000");
  props.put("num.partitions", "144");
  props.put("key.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
  props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
  private val consumer = new KafkaConsumer[Array[Byte], Array[Byte]](props);
  consumer.subscribe(java.util.Arrays.asList(topic));



  override def init(ctx: ComputationContext): Unit = {
    logger.info(s"Consumer for kafka `$topic` initialized. Brokers: $broker. From begining $fromBeginning")
    ctx.setTimer("loop", System.currentTimeMillis())
    if(fromBeginning) {
      consumer.poll(1) // need to fetch the assignments
      import scala.collection.JavaConversions._
      consumer.assignment().foreach( (partition: TopicPartition) => {
        logger.info(s"Seeking to begining for partition: $partition")
        consumer.seekToBeginning(partition)
      })
    }
    thread.start
  }
  override def destroy(): Unit = {
    consumer.close()
    logger.info(s"Consumer for kafka `$topic` closed")
  }
  override def processRecord(ctx: ComputationContext, record: Record): Unit = ???
  override def processTimer(ctx: ComputationContext, key: String, time: Long): Unit = {
    var counter = 0
    var loop = true
    while(loop && counter <= 10240 && recordCount.decrementAndGet() > 1) {
      counter += 1
      val r = queue.poll
      if(r != null) { // wrap in Option[Tuple2(byte[], byte[])]?
        ctx.produceRecord(topicBytes, r._1, r._2)
      }else {
        loop = false;
      }
    }
    ctx.setTimer(key, System.currentTimeMillis())
  }

  override def metadata(): Metadata = {
    val m = new Metadata("concord-kafka-source-" + topic,
      new MutableHashSet[StreamTuple](),
      new MutableHashSet[String](java.util.Arrays.asList(topic)))
    logger.info(s"Metadata: $m")
    m
  }
}

object ConcordKafkaConsumerRunner extends App {
  val brokers = System.getenv("ConcordKafkaBrokers")
  val topic = System.getenv("ConcordKafkaTopic")
  val beginning = System.getenv("ConcordKafkaFromBeginning").toBoolean
  checkNotNull(topic)
  checkNotNull(brokers)
  verify(!topic.isEmpty, "Cannot read an empty topic from kafka")
  verify(!brokers.isEmpty,
    "Cannot start reading from kafka with no broker's to connect to")
  ServeComputation.serve(new ConcordKafkaConsumer(brokers, topic, beginning))
}
