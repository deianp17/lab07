package api

import busymachines.json._
import busymachines.rest.jsonrest._
import database.Database
import datamodels.User
import akka.http.scaladsl.server.Directives._

import scala.concurrent.ExecutionContext

trait UserApi extends JsonSupport{
  implicit val userSerializer: Codec[User] = derive.codec[User]

  val userRoute =
    path("user") {
      post {
        entity(as[User]) {
          user => complete(Database.addUser(user))
        }
      } ~ get {
        complete(Database.getAllUsers)
      }
    }
}
