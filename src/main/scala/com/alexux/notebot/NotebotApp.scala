package com.alexux.notebot

import akka.util.Timeout
import com.alexux.notebot.services.SprayActor
import scala.concurrent.duration._
import akka.actor.{Props, ActorSystem}
import akka.io.IO
import akka.pattern.ask
import spray.can.Http
import scala.util.Properties

/**
  * Created by v.bazarevsky on 4/9/2016.
  */
object NotebotApp extends App {
  implicit val system = ActorSystem("on-spray-can")
  val service = system.actorOf(Props[SprayActor], "demo-service")
  val port = Properties.envOrElse("PORT", "8080").toInt
  implicit val timeout = Timeout(5.seconds)
  IO(Http) ask Http.Bind(service, interface = "0.0.0.0", port = port)
}
