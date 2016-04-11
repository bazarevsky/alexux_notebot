package com.alexux.notebot.services

import com.alexux.notebot.model.Note
import play.api.libs.json.Json
import spray.http.MediaTypes._
import spray.routing.HttpService
import spray.httpx.PlayJsonSupport._

/**
  * Created by v.bazarevsky on 4/11/2016.
  */
trait NoteService extends HttpService {
  implicit val noteReadSerializer = Json.reads[Note]
  implicit val noteWriteSerializer = Json.format[Note]

  val noteRoute = path("v1" / "note") {
    get {
      respondWithMediaType(`application/json`) {
        complete(Note(12, "name", "category", "text"))
      }
    } ~ post {
      respondWithMediaType(`application/json`) {
        entity(as[Note]) { case Note(id, name, category, text) =>
          complete(Note(id + 1, name, category, text))
        }
      }
    }
  }
}
