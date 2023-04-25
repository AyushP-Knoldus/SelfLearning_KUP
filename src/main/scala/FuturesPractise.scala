package com.knoldus

import scala.annotation.tailrec
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

object FuturesPractise extends App {
  private val aFuture = Future {
    Thread.sleep(1000)
    "Ayush"
  }
  println(aFuture.value)

  Await.ready(aFuture, 1.seconds)
  aFuture.onComplete {
    case Success(value) => println(value)
    case Failure(exception) => println(exception)
  }

  private val secondFuture = Future {
    throw new Exception("Future failed")
  }

  secondFuture.recover {
    case exception: Exception => println(exception)
  }

  val number = 5
  computeFactorial(number).onComplete {
    case Success(value) => println(value)
    case Failure(exception) => println(exception)
  }

  private def computeFactorial(number: Int): Future[Int] = {
    Future {
      @tailrec
      def calculateFactorialHelper(number: Int, result: Int): Int = {
        number match {
          case 0 => result
          case 1 => result
          case _ => calculateFactorialHelper(number - 1, number * result)
        }
      }

      if (number < 0)
        throw new Exception("Invalid number")
      else
        calculateFactorialHelper(number, 1)
    }
  }
}