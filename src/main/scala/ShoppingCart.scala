/**
  * Created by kerimc on 19.04.2017.
  */
object ShoppingCart {

  private val catalog: Map[String, Item] = Map("orange" -> Item("orange", 0.25), "apple" -> Item("apple", 0.60))

  def itemPrice(itemName: String): BigDecimal = {
    catalog.getOrElse(itemName.toLowerCase, Item("na", 0)).price
  }

  def checkOut(items: Array[String]): BigDecimal = {
    items.map(itemPrice(_)).sum
  }
}
