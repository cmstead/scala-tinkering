import org.scalatest._
import CurryTest._

class CurryTestSpec extends FlatSpec with Matchers {

  it should "provide a simple curried adder" in {
    val result = curriedAdd(5)(2)
    result should be (7)
  }

  it should "provide a means to make an incrementer" in {
    val incBy3 = curriedAdd(3)
    val result = (incBy3 compose incBy3 compose incBy3)(5)

    result should be (14)
  }

  it should "pipeline functions" in {
    val incBy5 = curriedAdd(5)
    val mulBy3 = curriedMul(3)

    val result = (Function chain Seq(
      incBy5,
      mulBy3,
      mulBy3,
      incBy5
    ))(7)

    result should be (113)
  }

  it should "create a range" in {
    val result = curriedRange(1)(10)
    val expected = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: 8 :: 9 :: 10 :: Nil

    result should be (expected)
  }

  it should "create a range with reversed bounds" in {
    val result = curriedRange(10)(1)
    val expected = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: 8 :: 9 :: 10 :: Nil

    result should be (expected)
  }

}
