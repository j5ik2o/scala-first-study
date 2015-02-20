package scala_sample.part2

import java.util.Currency

// case class導入
case class Money(currency: Currency,
                 amount: BigDecimal)

object Money {

  val JPY = Currency.getInstance("JPY")

  val USD = Currency.getInstance("USD")

}

object Part2Main extends App {

  val money1 = Money(Money.JPY, 100)
  val money2 = Money(Money.JPY, 100)

  println(money1.currency)
  println(money1.amount)
  println(money1)

  println(money1 == money2)
}
