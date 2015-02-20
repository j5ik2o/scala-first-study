package scala_sample.part0

import java.util.Currency

// クラス定義
class Money(val currency: Currency,
            val amount: BigDecimal)

object Part0Main extends App {

  val JPY = Currency.getInstance("JPY")
  val money1 = new Money(JPY, 100)
  val money2 = new Money(JPY, 100)

  println(money1.currency)
  println(money1.amount)
  println(money1)

  println(money1 == money2)

}
