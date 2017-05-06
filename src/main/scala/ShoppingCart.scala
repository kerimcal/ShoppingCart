/**
  * Created by kerimc on 19.04.2017.
  */
object ShoppingCart {

  private val catalog: Map[String, Item] =
    Map("orange" -> Item("orange", 0.25, chargeableItemCountsInOfferThreeForTwo),
      "apple" -> Item("apple", 0.60, chargeableItemCountsInOfferTwoForOne)
    )

  def itemPrice(itemName: String): BigDecimal = {
    catalog.getOrElse(itemName.toLowerCase, Item("na", 0, defChargeableItemCounts)).price
  }

  def checkOut(items: Array[String]): BigDecimal = {
    items.map(itemPrice(_)).sum
  }

  def checkOutWithOffer(items: Array[String]): BigDecimal = {
    items.groupBy(i => i).map(kv => offer(kv._1, kv._2.length)).sum
  }

  private def offer(itemName: String, itemCnt: Int): BigDecimal = {
    itemChargeableItemCountCalculator(itemName)(itemCnt) * itemPrice(itemName)
  }

  private def chargeableItemCountsInOfferTwoForOne(itemCnt: Int): Int = (itemCnt / 2) + (itemCnt % 2)

  private def chargeableItemCountsInOfferThreeForTwo(itemCnt: Int): Int = 2 * (itemCnt / 3) + (itemCnt % 3)

  private def defChargeableItemCounts(itemCnt: Int): Int = itemCnt

  def itemChargeableItemCountCalculator(itemName: String): Int => Int = {
    catalog.getOrElse(itemName.toLowerCase, Item("na", 0, defChargeableItemCounts)).chargeableItemCountCalculator
  }
}
