package scala_sample.part13

// インターフェイスとしてのtrait
trait Greeting {
  def getMessage: String
}

// 抽象クラス
abstract class AbstractGreeting(target: String) extends Greeting {

  protected val messageFormat: String

  override def getMessage: String = messageFormat.format(target)

}

// 具象クラス
class GreetingJapanese(target: String) extends AbstractGreeting(target) {
  override protected val messageFormat: String = "%sさん、こんにちは"
}

// 具象クラス
class GreetingEnglish(target: String) extends AbstractGreeting(target) {
  override protected val messageFormat: String = "%s, Hello"
}

object Main extends App {

  private def say(greeting: Greeting): Unit = {
    println(greeting.getMessage)
  }

  args match {
    case Array(lang, user) => lang match {
      case "JP" => say(new GreetingJapanese(user))
      case "EN" => say(new GreetingEnglish(user))
      case _ => println("指定されたあいさつは実行できません")
    }
    case _ => println("引数が不正です")
  }

}
