libraryDependencies ++= Seq(
  "com.facebook.swift" % "swift-service" % "0.14.1",
  "com.facebook.swift" % "swift-codec" % "0.14.1"
)

javaSource in Compile := baseDirectory.value / "gen-swift"
