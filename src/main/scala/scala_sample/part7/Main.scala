package scala_sample.part7

object Main extends App {

  def debugPrint(x: Int, func: Int => Int): Unit = {
    val result = func(x)
    println("result = " + result)
  }

  val square = (x: Int) => x * x

  debugPrint(2, square)


  def newDebugFunc(func: Int => Int): Int => Int = {
    val debugFunc = (x: Int) => {
      val result = func(x)
      println("result = " + result)
      result
    }
    debugFunc
  }

  val squareDebug = newDebugFunc(square)
  val result = squareDebug(5)
}
