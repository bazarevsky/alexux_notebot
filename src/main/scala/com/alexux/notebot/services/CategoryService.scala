package com.alexux.notebot.services

import com.alexux.notebot.model.Category
import play.api.libs.json.Json
import spray.http.MediaTypes._
import spray.routing.HttpService
import spray.httpx.PlayJsonSupport._

/**
  * Created by v.bazarevsky on 4/11/2016.
  */
trait CategoryService extends HttpService {
  implicit val categoryReadSerializer = Json.reads[Category]
  implicit val categoryWriteSerializer = Json.format[Category]

  val categoryRoute = path("v1" / "category") {
    get {
      respondWithMediaType(`application/json`) {
        complete {
          Category("hello", "description")
        }
      }
    } ~ post {
      respondWithMediaType(`application/json`) {
        entity(as[Category]) { category: Category =>
          complete(category)
        }
      }
    }
  }
}
