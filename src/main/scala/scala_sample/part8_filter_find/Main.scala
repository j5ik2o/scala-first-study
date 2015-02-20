package scala_sample.part8_filter_find

object Main extends App {

  val numbers = Seq(1, 2, 3, 4, 5)

  def isEven(value: Int): Boolean = {
    value % 2 == 0
  }

  val evenF = isEven _

  val newNumbers = numbers.filter(evenF)

  println(newNumbers)

}
