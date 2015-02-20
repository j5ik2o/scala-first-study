package scala_sample

import org.apache.commons.lang3.StringUtils

object JavaApiSample extends App {

  {
    println(StringUtils.capitalize("personName"))

    // Scalaのみで可能。こっちのがシンプル
    println("personName".capitalize)
  }

  {
    println(StringUtils.join(Array[AnyRef]("Septeni", "Scala"), " X "))

    // Scalaのみで可能。こっちのがシンプル
    println(Seq("Septeni", "Scala").mkString(" X "))
  }

  {
    println(StringUtils.reverse("inetpeS"))

    // Scalaのみで可能。こっちのがシンプル
    println("inetpeS".reverse)
  }

}

