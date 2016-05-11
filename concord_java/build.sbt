name := "concord"

version := "0.1.2"

autoScalaLibrary := false

crossPaths := false

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % "1.7.7",
  "org.slf4j" % "slf4j-api" % "1.7.7",
  "org.apache.thrift" % "libthrift" % "0.9.2",
  "com.google.guava" % "guava" % "19.0-rc2"
)
