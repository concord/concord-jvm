import sbt._
import Keys._

import sbtassembly.AssemblyKeys._
import sbtassembly._

object ConcordJvmBuild extends Build {
  lazy val scalaSettings = Seq(
    scalaVersion := "2.11.6",
    version := "0.1.0",
    scalacOptions := Seq("-Xlint", "-deprecation", "-Xfatal-warnings")
  )

  assemblyMergeStrategy in assembly := {
    case x if x.endsWith("project.clj") => MergeStrategy.discard
    case x if x.toLowerCase.startsWith("meta-inf") => MergeStrategy.discard
    case _ => MergeStrategy.first
  }

  lazy val rawapi = project
    .settings(crossPaths := false, autoScalaLibrary := false) // java only

  lazy val concord_java = project
    .settings(crossPaths := false, autoScalaLibrary := false) // java only
    .dependsOn(rawapi)


  lazy val getting_started  = project
    .settings(scalaSettings: _*)
    .dependsOn(rawapi)
    .dependsOn(concord_java)


  lazy val root = (project in file("."))
    .aggregate(rawapi, concord_java, getting_started)
}
