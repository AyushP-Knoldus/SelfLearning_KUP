package com.knoldus

object ForComprehension extends App {

  private val ageOfVoters = List(20, 17, 23, 55, 19)
  private val eligibility = for {
    candidate <- ageOfVoters
  } yield {
    if (candidate >= 18) "Eligible"
    else "Not eligible"
  }
  println(eligibility)

  private val listOfNumbers = List(2, 5, 7, 11, 12, 18, 20)
  private val list2 = List(12, 2, 4, 2, 99)

  private val squareOfoddNumbers = for {
    number <- listOfNumbers if number % 2 != 0
  } yield number * number

  println(squareOfoddNumbers)

  private val productOfLists = listOfNumbers.flatMap { value =>
    list2.map { number =>
      value * number
    }
  }

  private val anotherProductOfList = for {
    value1 <- listOfNumbers
    value2 <- list2
  } yield value1 * value2

  println(anotherProductOfList)
  println(productOfLists)

}
