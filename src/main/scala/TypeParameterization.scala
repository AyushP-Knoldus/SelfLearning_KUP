package com.knoldus

object TypeParameterization extends App {

  private val printObject1 = new PrintNTimes[String]
  printObject1.printValue("hello", 3)

  private val printObject2 = new PrintNTimes[Int]
  printObject2.printValue(4, 4)

  private val printObject3 = new PrintNTimes[Double]
  printObject3.printValue(3.9, 4)

  private val dog = Animal("Dog", "Domestic")

  private val printObject4 = new PrintNTimes[Animal]
  printObject4.printValue(dog, 3)

}

case class Animal(name: String, animalType: String)


class PrintNTimes[A] {

  def printValue(value: A, number: Int): Unit = {
    if (number <= 0) print("")
    else {
      println(value)
      printValue(value, number - 1)
    }
  }
}
