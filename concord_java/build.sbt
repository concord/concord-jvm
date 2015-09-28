name := "concord-java"

version := "1.0"

resolvers += Resolver.sonatypeRepo("public")

libraryDependencies ++= Seq(
  "com.facebook.swift" % "swift-service" % "0.15.1",
  "com.facebook.swift" % "swift-codec" % "0.15.1",
  "org.slf4j" % "slf4j-simple" % "1.7.7",
  "org.slf4j" % "slf4j-api" % "1.7.7",
  "org.apache.thrift" % "libthrift" % "0.9.2"
)

defaultScalariformSettings
