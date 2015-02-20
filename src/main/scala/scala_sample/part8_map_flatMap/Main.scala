package scala_sample.part8_map_flatMap

import scala.collection.mutable

object Main extends App {
  {
    val numbers = Seq(1, 2, 3, 4, 5)

    val square = (x: Int) => x * x

    val newNumbers1 = numbers.map { number =>
      square(number)
    }
    println(newNumbers1)

    val newNumbers2 = numbers.map(square)
    println(newNumbers1)

    val newNumbers3 = for (number <- numbers) yield square(number)
    println(newNumbers3)
  }
  {
    case class Person(id: Int, name: Option[String], deptName: String)

    object PersonRepository {

      private val entities = mutable.Map.empty[Int, Person]

      def store(person: Person): Unit =
        entities += (person.id -> person)

      def findById(id: Int): Option[Person] =
        entities.get(id)

      def toSeq: Seq[Person] = entities.map(_._2).toSeq

    }

    PersonRepository.store(Person(1, Some("KATO"), "tech"))
    PersonRepository.store(Person(2, None, "sales"))
    PersonRepository.store(Person(3, Some("ADACHI"), "tech"))

    PersonRepository.toSeq.foreach(println)

    {
      // Option型の使いかた
      val personOpt = PersonRepository.findById(2)
      if (personOpt.isDefined) {
        println(personOpt.get)
      }

      personOpt.foreach{
        person =>
          println(person)
      }
      personOpt.foreach(println)

      // 部署名だけ取り出す
      personOpt.map(_.deptName).foreach{deptName => println(s"deptName = $deptName")}

    }

    {
      // これだとOption[Option[String]] になる
      val name: Option[Option[String]] = PersonRepository.findById(2).map { person =>
        person.name
      }

      println("name = " + name)
    }

    {
      val name: Option[String] = PersonRepository.findById(2).flatMap { person =>
        person.name
      }

      println("name = " + name)
    }

    {
      val nameSize: Option[Int] = PersonRepository.findById(2).flatMap { person =>
        person.name.map(_.size)
      }

      println("nameSize = " + nameSize)
    }

    {
      val nameSize = for {
        person <- PersonRepository.findById(2)
        name <- person.name
      } yield name.size

      println("nameSize = " + nameSize)
    }

  }
}
