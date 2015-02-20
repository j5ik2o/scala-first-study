package scala_sample

object MethodSample {

  def printText(value: String): Unit =
    println(value)

  def addValues(a: Int, b: Int): Int = a + b

  printText("abc")
  println("addValues(1, 2) = " + addValues(1, 2))

}
