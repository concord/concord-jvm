package io.concord;
import java.util.{ HashSet => MutableHashSet}
import io.concord._
import io.concord.swift._
import com.typesafe.scalalogging.LazyLogging
import org.apache.kafka.clients.producer.{
  KafkaProducer,
  ProducerRecord
}
import com.google.common.base.Verify.verify
import com.google.common.base.Preconditions.checkNotNull
import scala.util.Random

object ConcordKafkaProducer  {
  private val rand = new Random
  private val words = Array("foo", "bar", "baz", "fiz", "buzz")
  def next: String = {
    words(rand.nextInt(words.length))
  }
}

class ConcordKafkaProducer(val broker: String, val topic: String)
    extends Computation with LazyLogging {
  private val props = new java.util.Properties();
  private var counter = 0
  private val counterKeyBytes = (topic + "_producer_counter").getBytes
  private val topicBytes = topic.getBytes

  props.put("bootstrap.servers", broker);
  props.put("num.partitions", "144");
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

  val producer = new KafkaProducer[String,String](props);

  override def init(ctx: ComputationContext): Unit = {
    ctx.setTimer("loop", System.currentTimeMillis())
    logger.info(s"${this.getClass.getSimpleName} for topic $topic initialized")
  }
  override def destroy(): Unit = {
    producer.close()
    logger.info(s"${this.getClass.getSimpleName} kafka connection closed")
  }
  override def processRecord(ctx: ComputationContext, record: Record): Unit = ???
  override def processTimer(ctx: ComputationContext, key: String, time: Long): Unit = {
    val step = 1024
    for(i <- 0 to step) {
      import ConcordKafkaProducer.{next => generator}
      val data = new ProducerRecord(topic, generator, generator)
      producer.send(data);
    }
    counter += step
    ctx.produceRecord(topicBytes, counterKeyBytes, counter.toString.getBytes)
    ctx.setTimer(key, System.currentTimeMillis())
  }
  override def metadata(): Metadata = {
    import java.util.Arrays.asList
    val m = new Metadata("concord-kafka-producer-" + topic,
      new MutableHashSet[StreamTuple](),
      new MutableHashSet[String](asList(topic + "_producer_counter")))
    logger.info(s"Metadata: $m")
    m
  }
}

object ConcordKafkaProducerRunner extends App {
  val brokers = System.getenv("ConcordKafkaBrokers")
  val topic = System.getenv("ConcordKafkaTopic")
  checkNotNull(topic)
  checkNotNull(brokers)
  verify(!topic.isEmpty, "Cannot write an empty topic from kafka")
  verify(!brokers.isEmpty,
    "Cannot start reading from kafka with no broker's to connect to")
  ServeComputation.serve(new ConcordKafkaProducer(brokers, topic))
}
