package com.alexux.notebot

import akka.util.Timeout
import com.alexux.notebot.model.Category
import com.alexux.notebot.repositories.mongo.RepositoryContext
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
  val mongoConnectionString = Properties.envOrElse("MONGOLAB_URI", "mongodb://localhost:27017/test")
  val mongoDbName = Properties.envOrElse("MONGOLAB_DBNAME", "test")

//  val repositoryContext = new RepositoryContext(mongoConnectionString, mongoDbName)
//  repositoryContext.categoryRepository.add(Category("test", "cater"))
//
//  val results = repositoryContext.categoryRepository.list()
//  results.foreach(c => println(c.name))

  implicit val timeout = Timeout(5.seconds)
  IO(Http) ask Http.Bind(service, interface = "0.0.0.0", port = port)
}
