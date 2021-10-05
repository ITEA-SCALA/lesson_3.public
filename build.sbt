ThisBuild / scalaVersion := "2.13.2"
ThisBuild / organization := "com.itea"
ThisBuild / organizationName := "itea"
ThisBuild / version := "0.1.0-SNAPSHOT"

val setLog4jDebug = sys.props("log4j2.debug") = "true"

lazy val root = (project in file("."))
  .settings(
    name := "Lesson-3",
	  libraryDependencies ++= Seq(
	    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
      "org.slf4j" % "slf4j-api" % "1.7.30",
      "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.13.3",
      "org.scalatest" %% "scalatest" % "3.1.0",
      "com.typesafe" % "config" % "1.4.1",
      "io.bfil" %% "automapper" % "0.7.0",

      "com.typesafe.akka" %% "akka-stream" % "2.5.23",
      "com.typesafe.akka" %% "akka-http" % "10.1.8"
	  ),
    scalacOptions ++= Seq("-deprecation")
)
