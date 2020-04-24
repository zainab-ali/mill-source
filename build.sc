import mill._

object myModule extends Module {

  def first = T.source {
    PathRef(millSourcePath / "first.txt")
  }

  def second = T {
    val f = first()
    println("The first.txt file was modified")
  }
}