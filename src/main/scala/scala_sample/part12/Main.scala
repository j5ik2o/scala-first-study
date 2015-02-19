package scala_sample.part12

case class Task(name: String)

sealed trait Worker {
  val name: Name
  val postalAddress: PostalAddress
}

case class Name(firstName: String, lastName: String)
case class PostalAddress(prefCode: Int, cityName: String, addressName: String, buildingName: Option[String])
case class Employee(name: Name, postalAddress: PostalAddress) extends Worker
case class PartTimer(name: Name, postalAddress: PostalAddress, boss: Employee) extends Worker

object Main extends App {

  def getFirstNameAndPrefCodeOfEmployee(worker: Worker) = worker match {
    case Employee(Name(firstName, _), PostalAddress(prefCode, _, _, _)) => (firstName, prefCode)
    case PartTimer(Name(firstName, _), _, Employee(_, PostalAddress(prefCode, _, _, _))) => (firstName, prefCode)
  }

  val employee = Employee(Name("Junichi", "Kato"), PostalAddress(1, "荒川区", "東日暮里2-19-12", None))
  val partTimer = PartTimer(Name("Junichi", "Kato"), PostalAddress(2, "台頭区", "東日暮里2-19-12", None), employee)
  println(getFirstNameAndPrefCodeOfEmployee(employee))
  println(getFirstNameAndPrefCodeOfEmployee(partTimer))
  
}
