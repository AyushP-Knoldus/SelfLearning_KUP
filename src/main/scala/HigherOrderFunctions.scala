package com.knoldus

object HigherOrderFunctions extends App {

  private def simpleCalculator(number1: Int, number2: Int, arithmeticOperation: (Int, Int) => Int) = {
    arithmeticOperation(number1, number2)
  }

  private val add = (num1: Int, num2: Int) => num1 + num2
  private val number1 = 3
  private val number2 = 5
  println(simpleCalculator(number1, number2, add))

  val inputList = List(2, 5, 7, 9)
  private val newList = List("a", "b", "c")

  //Map taking another function as input to increment each value by 1
  println(inputList.map(add(_, 1)))

  //filter and filternot method to print even and odd numbers in a list
  println(inputList.filter(_ % 2 == 0))
  println(inputList.filterNot(_ % 2 == 0))

  //FoldLeft Method on list
  println(inputList.foldLeft(1) { (result, number) => result * number })

  //flatMap method on list
  private val result = inputList.flatMap {
    element1 => newList.map(element2 => element1 + element2)
  }
  println(result)


}
