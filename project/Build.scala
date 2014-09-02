import sbt._
import sbt.{Build => SbtBuild}
import Keys._
import org.sbtidea.SbtIdeaPlugin._

object Build extends SbtBuild {
  val commonSettings = Seq(
    ideaExcludeFolders := ".idea" :: ".idea_modules" :: Nil,
    version := "1.0",
    organization := "org.test",
    scalaVersion := "2.11.1",
    crossPaths := false, // won't append Scala version to artifact
    scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation"),
    javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation"),
    resolvers ++= Seq(
      "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
      "Apache Snapshots" at "https://repository.apache.org/content/repositories/snapshots/"
    ),
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-api" % "1.7.5",
      "ch.qos.logback" % "logback-classic" % "1.0.13",
      "com.typesafe.akka" %% "akka-actor" % "2.3.5"
    )
  )

  val root = Project(
    id = "sbt-project-skeleton",
    base = file("."),
    settings = commonSettings
  )
}
