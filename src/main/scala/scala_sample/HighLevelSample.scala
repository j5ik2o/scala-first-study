package scala_sample

import java.io._

object HighLevelSample extends App {

  {
    def isNameHasUpperCase(text: String): Boolean =
      text.exists(_.isUpper)

    println("abc = " + isNameHasUpperCase("abc"))
    println("aBc = " + isNameHasUpperCase("aBc"))
  }

  {
    val out = new FileOutputStream(new File("bar1.txt"))
    try {
      out.write("abc".getBytes)
    } finally {
      out.close()
    }
  }

  {
    import Loan._
    val text = "abc"
    val result = using(new FileOutputStream(new File("bar2.txt"))) {
      out =>
        out.write(text.getBytes)
        text.size
    }
    println(result)
  }

}


import scala.language.reflectiveCalls
import scala.util._
import scala.util.control.NonFatal

object Loan {

  def using[A <: {def close()}, B](resource: A)(func: A => B): Try[B] =
    try {
      Success(func(resource))
    } catch {
      case NonFatal(e) => Failure(e)
    } finally {
      if (resource != null) resource.close()
    }

}
