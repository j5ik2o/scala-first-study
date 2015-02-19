package scala_sample.part10

object Main extends App {

  def convertNumberToString(obj: Any) = obj match {
    case n: Int => "one"
    case "2" => "two"
    case List(3,3,3) => "three"
    case _ => throw new IllegalArgumentException
  }

  println(convertNumberToString(1))
  println(convertNumberToString("2"))
  println(convertNumberToString(List(3,3,3)))
  println(convertNumberToString(0.5))

}
