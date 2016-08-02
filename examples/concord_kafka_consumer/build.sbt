name := "concord_kafka_consumer"

version := "0.0.3"

autoScalaLibrary := false

crossPaths := false

libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
  "org.apache.kafka" % "kafka-clients" % "0.9.0.0"
)
