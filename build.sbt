import sbt.Keys._
import sbt._

libraryDependencies ++= {
  Seq(
    "joda-time" % "joda-time" % "2.7",
    "org.slf4j" % "slf4j-log4j12" % "1.7.5",

    "org.scalatest" %% "scalatest" % "2.2.2" % Test,
    "org.scalacheck" %% "scalacheck" % "1.12.2" % Test
  )
}

