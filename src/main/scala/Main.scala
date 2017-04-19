/**
  * Created by kerimc on 19.04.2017.
  */
object Main {
    def main(items: Array[String]): Unit = {
        println(s"Basket with [ ${items.mkString(", ")} ] => £${ShoppingCart.checkOut(items)}")
    }
}
