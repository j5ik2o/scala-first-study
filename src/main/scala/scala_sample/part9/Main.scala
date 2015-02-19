package scala_sample.part9

object Main extends App {

  def numberMatch(n: Int) = n match {
    case 1 => println("one")
    case 2 | 3 => println("two or three")
    case _ => println("other")
  }

  numberMatch(1)
  numberMatch(2)
  numberMatch(3)
  numberMatch(4)
}
