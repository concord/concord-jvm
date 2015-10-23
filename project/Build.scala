import sbt._
import Keys._

import sbtassembly.AssemblyKeys._
import sbtassembly._

object ConcordJvmBuild extends Build {
  lazy val buildSettings = Defaults.defaultSettings ++ Seq(
    scalaVersion := "2.11.6",
    organization := "io.concord",
    libraryDependencies ++= Seq(
      "com.facebook.swift" % "swift-service" % "0.15.1",
      "com.facebook.swift" % "swift-codec" % "0.15.1"
    ),
    autoScalaLibrary := false,
    crossPaths := false
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
