package scala_sample

case class Color(red: Int, green: Int, blue: Int)

object SimpleSample extends App {

  val red = Color(255, 0, 0)
  val green = Color(0, 255, 0)
  val blue = Color(0, 0, 255)

  println(s"red = $red, green = $green, blue = $blue")

}
