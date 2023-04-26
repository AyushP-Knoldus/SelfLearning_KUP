package com.knoldus

object PatternMatching extends App {
  val patternMatchingTypes = new PatternMatchingTypes
  println(patternMatchingTypes.wildcardPattern("Rahul"))
  println(patternMatchingTypes.constantPattern())
  println(patternMatchingTypes.variablePattern(51))
  println(patternMatchingTypes.constructorPattern(Student("Rahul", 12, 'B')))
  println(patternMatchingTypes.sequencePattern(List(2, 8, 8)))
  println(patternMatchingTypes.tuplePattern("Ayush", 12, 'A'))
  println(patternMatchingTypes.typedPattern(12.3))
}

class PatternMatchingTypes {
  def wildcardPattern(name: String): String = {
    name match {
      case "Ayush" => "Found student Ayush"
      case "Rahul" => "Found student Rahul"
      case _ => "Student not found"
    }
  }

  def constantPattern(input: Any): String = {
    input match {
      case 22 => "Found number 22"
      case false => "Input is false"
      case "Ayush" => "Found candidate Ayush"
      case Nil => "Input is empty"
      case _ => "Input not found"
    }
  }

  def variablePattern(inputNumber: Int): String = {
    inputNumber match {
      case 45 => "Found number 45"
      case 26 => "Found number 26"
      case foundSomethingElse => s"Found $foundSomethingElse instead of number 45 and 26"
    }
  }

  def constructorPattern(student: Student): String = {
    student match {
      case Student("Ayush", 11, _) => "Student named Ayush found in 11th grade"
      case Student(_, _, 'B') => "Student is in B section"
      case _ => " Student not found"
    }
  }

  def sequencePattern(inputList: List[Int]): String = {
    inputList match {
      case List(_, 2) => "List starting with 2"
      case List(_, 5, _*) => "Second element of list is 5"
      case List(1, 3, 5, 7, 9, 11) => "List containing odd numbers"
      case Nil => "List is empty"
      case _ => "List dont match"
    }
  }

  def tuplePattern(student: Any): String = {
    student match {
      case ("Ayush", _, _) => "Student Ayush found."
      case _ => "Student not found"
    }
  }

  def typedPattern(inputType: Any): String = {
    inputType match {
      case d: Double => s"The input number is double type $inputType"
      case i: Int => s"The input number is Integer type $inputType"
      case _ => s"The result is $inputType"
    }
  }
}
