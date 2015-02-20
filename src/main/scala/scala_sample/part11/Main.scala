package scala_sample.part11

// case class の apply/unapply

class PersonName1(val firstName: String, val lastName: String) {

  override def equals(obj: scala.Any): Boolean = obj match {
    case that: PersonName1 => that.firstName == this.firstName && that.lastName == this.lastName
    case _ => false
  }

  override def hashCode(): Int = 31 * (firstName.hashCode + lastName.hashCode)

  override def toString: String = s"Person1($firstName, $lastName)"

}

object PersonName1 {

  def apply(firstName: String, lastName: String): PersonName1 =
    new PersonName1(firstName, lastName)

  def unapply(self: PersonName1): Option[(String, String)] =
    Some(self.firstName, self.lastName)

}

case class PersonName2(firstName: String, lastName: String)


object Main extends App {

  {
    val p1 = PersonName1("Junichi", "Kato")
    val p2 = PersonName1("Junichi", "Kato")

    println("equals = " + (p1 == p2))

    val PersonName1(f, l) = p1
    println(s"firstName = $f, lastName = $l")

    val PersonName1(_, l2) = p2
    println(s"lastName = $l2")
  }

  {
    val p1 = PersonName2("Junichi", "Kato")
    val p2 = PersonName2("Junichi", "Kato")

    println("equals = " + (p1 == p2))

    val PersonName2(f, l) = p1
    println(s"firstName = $f, lastName = $l")

    val PersonName2(_, l2) = p2
    println(s"lastName = $l2")
  }

  {
    val p1 = PersonName1("Junichi", "Kato")
    val p2 = PersonName2("Junichi", "Kato")

    println("equals = " + (p1 == p2))

//    val PersonName2(f, l) = p1
//    println(s"firstName = $f, lastName = $l")
//
//    val PersonName1(_, l2) = p2
//    println(s"lastName = $l2")
  }
}
