package scala_sample.part8

object Main extends App {

  val numbers = List(1, 2, 3)

  val newNumbers1 = 0 +: numbers; println(newNumbers1)
  val newNumbers2 = 0 :: numbers; println(newNumbers2)
  val newNumbers3 = numbers ++ List(4, 5); println(newNumbers3)
  val newNumbers4 = numbers :+ 4; println(newNumbers4)

  for(i <- 0 until numbers.size) {
    println(numbers(i))
  }

  for(number <- numbers) {
    println(number)
  }

  numbers.foreach(x => println(x))
  numbers.foreach(println(_))
  numbers.foreach(println)

}
