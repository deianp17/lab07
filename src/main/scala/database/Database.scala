package database

import java.util.UUID

import datamodels.User

import scala.collection.mutable
import scala.concurrent.{ExecutionContext, Future}


case class Database (implicit val ec: ExecutionContext){
  val db: mutable.HashMap[String, User] = mutable.HashMap[String, User]()

  def addUser(user: User): Future[String] = {
    for {
      userId <- randomId
      userWithId = User(userId, user.name, user.email, user.password)

    } yield userId
  }

  def getAllUsers: Seq[User] = {
    db.values.toSeq
  }

  def getUserById(id: String): User = {
    db.get(id)
  }


  private def randomId: Future[String] = Future.successful(UUID.randomUUID().toString)
}
