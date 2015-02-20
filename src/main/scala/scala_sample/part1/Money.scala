package scala_sample.part1

import java.util.Currency

// 値オブジェクト化
class Money(val currency: Currency,
            val amount: BigDecimal) {

  override def equals(obj: scala.Any): Boolean = obj match {
    case that: Money =>
      amount == that.amount &&
        currency == that.currency
    case _ => false
  }

  override def hashCode(): Int = 31 * (currency.hashCode() + amount.hashCode())

  override def toString: String = s"Money($currency, $amount)"

}

object Part1Main extends App {

  val JPY = Currency.getInstance("JPY")
  val money1 = new Money(JPY, 100)
  val money2 = new Money(JPY, 100)

  println(money1.currency)
  println(money1.amount)
  println(money1)

  println(money1 == money2)

}
