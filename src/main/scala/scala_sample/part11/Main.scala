package scala_sample.part11

case class PersonName(firstName: String, lastName: String)

object Main extends App {

  val p1 = PersonName("Junichi", "Kato")
  val p2 = PersonName("JUNICHI", "KATO")

  assert(p1 == p2)

  val PersonName(f, l) = p1
  println(s"firstName = $f, lastName = $l")

  val PersonName(_, l2) = p2
  println(s"lastName = $l2")

}
