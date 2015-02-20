package scala_sample.part4

import java.util.{Locale, Currency}

// 補助コンストラクタ定義
case class Money(currency: Currency,
                 amount: BigDecimal) {

  // 補助コンストラクタ
  def this(amount: BigDecimal) =
    this(Currency.getInstance(Locale.getDefault),
      amount)

  def plus(other: Money): Money = {
    require(currency == other.currency)
    Money(currency, amount + other.amount)
  }
  
  def +(other: Money) = plus(other)

}

object Money {

  val JPY = Currency.getInstance("JPY")

  val USD = Currency.getInstance("USD")

  def apply(amount: BigDecimal) = new Money(amount)

}

object Part4Main extends App {

  val y100 = Money(100)
  val y50 = Money(50)

  println("plus = " + (y100.plus(y50) == Money(Money.JPY, 150)))
  println("+ = " + (y100 + y50 == Money(Money.JPY, 150)))

}
