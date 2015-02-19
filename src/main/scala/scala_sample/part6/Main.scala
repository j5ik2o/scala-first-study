package scala_sample.part6

object Main extends App {

  val square = (x: Int) => x * x

  assert(square(2) == 4)

  val squareDebug = (x: Int) => {
    val result = x * x
    println("result = " + result)
    result
  }

  assert(squareDebug(2) == 4)


}
