package scala_sample.part14

import scala.collection.mutable.Map

case class Employee(id: Int, name: String)

abstract class AbstractEmployeeRepository {
  private[part14] val entities = Map.empty[Int, Employee]

  def toMap = entities.toMap

  def toList = entities.toList
}

trait ReadableEmployeeRepository {
  this: AbstractEmployeeRepository =>

  def findById(id: Int): Option[Employee] = entities.get(id)
}

trait WritableEmployeeRepository {
  this: AbstractEmployeeRepository =>

  def store(employee: Employee): Unit =
    entities += (employee.id -> employee)
}

class EmployeeReadOnlyRepository
  extends AbstractEmployeeRepository
  with ReadableEmployeeRepository

class EmployeeRepository
  extends AbstractEmployeeRepository
  with ReadableEmployeeRepository
  with WritableEmployeeRepository {

  def toReadable = {
    val result = new EmployeeReadOnlyRepository
    result.entities ++= entities
    result
  }

}

object Main extends App {
  val kato = Employee(1, "KATO")
  val repository = new EmployeeRepository
  repository.store(kato)
  repository.findById(1).foreach {
    employee =>
      println("repository = " + (employee == kato))
  }

  val readableRepository = repository.toReadable
  readableRepository.findById(1).foreach{ employee =>
    println("readableRepository = " + (employee == kato))
  }
  // compile error
  // readableRepository.store(kato)

}
