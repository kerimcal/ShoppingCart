import org.scalatest.FunSuite

/**
  * Created by kerimc on 19.04.2017.
  */
class ShoppingCartTest extends FunSuite {

  test("undefined item price should be returned as 0") {
    val r = ShoppingCart.itemPrice("pineapple")
    assert(r == 0)
  }

  test("defined item price should be returned with a value greater than 0") {
    val r = ShoppingCart.itemPrice("apple")
    assert(r > 0)
  }

  test("it should successfully calculate sum of defined items as greater than 0") {
    val r = ShoppingCart.checkOut(Array("apple", "orange"))
    assert(r > 0)
  }

  test("it should successfully calculate sum of undefined items as 0") {
    val r = ShoppingCart.checkOut(Array("pineapple", "fig"))
    assert(r == 0)
  }

  test("it should successfully calculate sum of empty array as 0") {
    val r = ShoppingCart.checkOut(Array())
    assert(r == 0)
  }

  test("it should successfully checkout with apple offer") {
    val r = ShoppingCart.checkOutWithOffer(Array("apple", "apple", "apple", "apple"))
    assert(r == 1.2)
  }

  test("it should successfully checkout with orange offer") {
    val r = ShoppingCart.checkOutWithOffer(Array("orange", "orange", "orange", "orange"))
    assert(r == 0.75)
  }

  test("it should successfully checkout with mixed offer") {
    val r = ShoppingCart.checkOutWithOffer(Array("orange", "orange", "orange", "apple", "apple"))
    assert(r == 1.1)
  }
}
