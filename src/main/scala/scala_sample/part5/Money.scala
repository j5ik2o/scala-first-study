package scala_sample.part5

import java.util.{Currency, Locale}

// コンパニオンオブジェクトの定数およびメソッド利用
case class Money(currency: Currency, amount: BigDecimal) {

  // 補助コンストラクタ
  def this(amount: BigDecimal) = this(Money.Default, amount)

  def plus(other: Money): Money = {
    require(currency == other.currency)
    Money(currency, amount + other.amount)
  }

  def +(other: Money) = plus(other)

}

object Money {

  val JPY = Currency.getInstance("JPY")

  val USD = Currency.getInstance("USD")

  val Default = Currency.getInstance(Locale.getDefault)

  def apply(amount: BigDecimal) = new Money(amount)

  def sum(monies: Seq[Money]): Money =
    monies.reduceLeft{
      (l, r) =>
        l + r
    }

}

object Part5Main extends App {

  val y100 = Money(100)
  val y50 = Money(50)

  println("plus = " + (y100.plus(y50) == Money(Money.JPY, 150)))
  println("+ = " + (y100 + y50 == Money(Money.JPY, 150)))

  val sum = Money.sum(Seq(y100, y50))
  println("sum = " + sum)

}
