package com.knoldus

object PartialFunctions extends App {
  val inputList: List[Double] = List(16, 4, 5, -1, 81)
  private val squareRoot = new PartialFunction[Double, Double] {
    def apply(number: Double): Double = Math.sqrt(number)

    def isDefinedAt(number: Double): Boolean = number > 0
  }
  println(squareRoot(9))
  println(squareRoot.isDefinedAt(-1))

  //Other approach
  private val squareRootOther: PartialFunction[Double, Double] = {
    case d: Double if d > 0 => Math.sqrt(d)
  }
  println(inputList.collect(squareRootOther))

  //Example
  private val GradeCalculator: PartialFunction[Int, String] = {
    case marks if marks >= 0 && marks < 30 => "E"
    case marks if marks >= 30 && marks < 49 => "D"
    case marks if marks >= 49 && marks < 60 => "C"
    case marks if marks >= 60 && marks < 80 => "B"
    case marks if marks >= 80 && marks <= 100 => "A"
  }
  private val marks: List[Int] = List(10, 91, 75, 75, 22, 0, 100)

  //  println(marks.collect(gradeE))
  println(marks.map(GradeCalculator))
}