package com.alexux.notebot.services

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

/**
  * Created by v.bazarevsky on 4/9/2016.
  */
class SprayActor extends Actor with DefaultService {
  def actorRefFactory = context
  def receive = runRoute(defaultRoute)
}

trait DefaultService extends HttpService {
  val defaultRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>Say hello to <i>spray-routing</i> on <i>spray-can</i>!</h1>
              </body>
            </html>
          }
        }
      }
    }
}