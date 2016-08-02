import sbt._
import Keys._

import sbtassembly.AssemblyKeys._
import sbtassembly._

object ConcordJvmBuild extends Build {
  lazy val buildSettings = Defaults.defaultSettings ++ Seq(
    scalaVersion := "2.11.7",
    organization := "io.concord",
    scalacOptions := Seq("-Xlint", "-deprecation", "-Xfatal-warnings"),
    libraryDependencies ++= Seq(
      "com.facebook.swift" % "swift-service" % "0.18.0",
      "com.facebook.swift" % "swift-codec" % "0.18.0"
    )
  )

  lazy val rawapi = project
    .settings(buildSettings: _*)

  lazy val concord_java = project
    .dependsOn(rawapi)
    .settings(buildSettings: _*)

  lazy val root = (project in file("."))
    .aggregate(rawapi, concord_java)
    .settings(buildSettings: _*)
}
