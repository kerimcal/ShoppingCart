/**
  * Created by kerimc on 25.04.2017.
  */
trait OfferThreeForTwo {
  def checkOutItem(itemCnt: Int, itemPrice: BigDecimal): BigDecimal = (2 * (itemCnt / 3) + (itemCnt % 3)) * itemPrice
}
