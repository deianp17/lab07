package datamodels
import busymachines.core._
import busymachines.effects._

case class User(id: String, name: String, email: String, password: String)

case class UserNotFoundException(id: String) extends Exception(s"User with ${id} not found!")

object ValidEmail{
  private val emailRegex = """^[a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$""".r

  def isEmailValid(email: String): Boolean = email match {
    case null                                                  => false
    case email if email.trim.isEmpty                           => false
    case email if emailRegex.findFirstMatchIn(email).isDefined => true
    case _                                                     => false
  }
}

object ValidPassword {
  def isPasswordValid(pw: String): Boolean = {
    if(pw.length < 6)
      return false
    else if (pw.exists(_.isLetter) && pw.exists(_.isDigit))
      return true
    return false
  }
}

object UserRole {

  def fromName(s: String): Result[UserRole] =
    nameToRole
      .get(s)
      .asResult(InvalidInputFailure(s"UserRole has to be one of $allString, but was: $s"))

  lazy val all = Set(
    Admin,
    Regular,
  )

  lazy val nameToRole: Map[String, UserRole] = all.map(s => (s.productPrefix, s)).toMap

  lazy val allString = all.mkString("[", ",", "]")
}

sealed trait UserRole extends Product

case object Admin          extends UserRole
case object Regular        extends UserRole
