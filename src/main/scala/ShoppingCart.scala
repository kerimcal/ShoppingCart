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

  def checkOutWithOffer(items: Array[String]): BigDecimal = {
    items.groupBy(i => i).map(kv => offer(kv._1, kv._2.length)).sum
  }

  private def offer(itemName: String, itemCnt: Int): BigDecimal = {
    itemName.toLowerCase match {
      case "apple" => offerTwoForOne.checkOutItem(itemCnt, itemPrice(itemName))
      case "orange" => offerThreeForTwo.checkOutItem(itemCnt, itemPrice(itemName))
      case _ => itemCnt * itemPrice(itemName)
    }
  }

  val offerTwoForOne: Offer = new Offer with OfferTwoForOne
  val offerThreeForTwo: Offer = new Offer with OfferThreeForTwo
}
