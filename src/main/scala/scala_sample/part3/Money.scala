package scala_sample.part3

import java.util.Currency

// メソッド追加
case class Money(currency: Currency,
                 amount: BigDecimal) {
  
  def plus(other: Money): Money = {
    require(currency == other.currency)
    Money(currency, amount + other.amount)
  }
  
  def +(other: Money) = plus(other)

}

object Money {

  val JPY = Currency.getInstance("JPY")

  val USD = Currency.getInstance("USD")

}

object Part3Main extends App {

  val y100 = Money(Money.JPY, 100)
  val y50 = Money(Money.JPY, 50)

  println("plus = " + (y100.plus(y50) == Money(Money.JPY, 150)))
  println("+ = " + (y100 + y50 == Money(Money.JPY, 150)))

}
