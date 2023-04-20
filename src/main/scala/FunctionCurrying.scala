package com.knoldus

object FunctionCurrying extends App {
  private def HigherOrderFunction(number: Int): Int => Int = {
    (increment: Int) => increment + number
  }

  private val functionResult = HigherOrderFunction(3)
  println(functionResult(8))

  println(HigherOrderFunction(5)(4))
}
