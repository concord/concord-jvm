import sbt._
import Keys._

object ConcordJvmBuild extends Build {
  lazy val scalaSettings = Seq(
    scalaVersion := "2.11.6",
    version := "0.1.0",
    scalacOptions := Seq("-Xlint", "-deprecation", "-Xfatal-warnings")
  )

  lazy val rawapi = project
    .settings(crossPaths := false, autoScalaLibrary := false)

  lazy val concord_java = project
    .settings(scalaSettings: _*)
    .dependsOn(rawapi)

  lazy val concord_scala = project
    .settings(scalaSettings: _*)
    .dependsOn(rawapi)

  lazy val getting_started = project
    .settings(scalaSettings: _*)
    .dependsOn(concord_java)
    .dependsOn(rawapi)

  lazy val root = (project in file("."))
    .aggregate(
      rawapi,
      concord_scala,
      concord_java
  )
}
