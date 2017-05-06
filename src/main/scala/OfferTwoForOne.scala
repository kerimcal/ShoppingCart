/**
  * Created by kerimc on 25.04.2017.
  */
trait OfferTwoForOne {
  def checkOutItem(itemCnt: Int, itemPrice: BigDecimal): BigDecimal = ((itemCnt / 2) + (itemCnt % 2)) * itemPrice
}
