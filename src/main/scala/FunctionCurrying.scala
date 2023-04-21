package com.knoldus

object FunctionCurrying extends App {
  private def higherOrderFunction(number: Int): Int => Int = {
    (increment: Int) => increment + number
  }

  private val functionResult = higherOrderFunction(3)
  println(functionResult(8))

  println(higherOrderFunction(5)(4))
}
