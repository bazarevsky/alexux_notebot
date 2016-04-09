import sbt.Keys._
import sbt._

name := "alex_ux_notebot"

scalaVersion := "2.11.5"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

enablePlugins(JavaAppPackaging)

libraryDependencies ++= {
  val akkaVersion = "2.3.+"
  val sprayV = "1.3.+"
  val slf4jVersion = "1.7.5"
  Seq(
    "com.typesafe.akka" %%  "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %%  "akka-testkit" % akkaVersion % "test",
    "io.spray"          %%  "spray-can"     % sprayV,
    "io.spray"          %%  "spray-routing" % sprayV,
    "io.spray"          %%  "spray-testkit" % sprayV  % "test",
    "io.spray"          %%  "spray-client"  % sprayV,
    "io.spray"          %%  "spray-json"   %  sprayV,
    "com.typesafe.play" %% "play-json" % "2.3.9",

    "org.mongodb" %% "casbah" % "2.8.0",

    "org.slf4j" % "slf4j-api" % slf4jVersion,
    "org.slf4j" % "log4j-over-slf4j" % slf4jVersion,

    "org.mockito" % "mockito-core" % "2.0.5-beta" % "test" exclude("org.hamcrest", "hamcrest-core"),
    "org.scalatest" %% "scalatest" % "2.2.2" % "test",
    "org.scalacheck" %% "scalacheck" % "1.12.2" % "test"
  )
}

