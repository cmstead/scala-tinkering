object CurryTest {

  def curriedAdd (a: Int) = (b: Int) => (() => a + b)()
  def curriedMul (a: Int) = (b: Int) => a * b

  // Range imperative code
  // def curriedRange (start: Int) = (end: Int) => {
  //   val cleanStart = if (start > end) end else start
  //   val cleanEnd = if (start > end) start else end
  //
  //   var count = cleanStart
  //   var range:Array[Int] = Array()
  //
  //   while (count <= cleanEnd) {
  //     range :+ count
  //     count = count + 1
  //   }
  //
  //   range
  // }

  def conditionalSwap (start: Int, end: Int) = {
    if (start > end) Array(end, start) else Array(start, end)
  }

  def buildRange (start:Int, end:Int, range:List[Int] = Nil): List[Int] = {
      if (start > end) range else buildRange(start, end - 1, end :: range)
    }

  def curriedRange (start: Int) = (end: Int) => {
    val Array(cleanStart, cleanEnd) = conditionalSwap(start, end)
    buildRange(cleanStart, cleanEnd)
  }

}
