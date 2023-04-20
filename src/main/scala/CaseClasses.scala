package com.knoldus

object CaseClasses extends App {

  //Parameters are promoted to fields in case class
  val student1 = Student("Ayush", 11, 'B')
  println(student1.name)
  //Using .toString method
  println(student1.toString)
  //Working of equals with instances of case classes
  val student2 = Student("Ayush", 11, 'B')
  println(student1 == student2)
  //Copy method with case class
  val student3 = student2.copy(name = "Rahul")
  //Syntactic sugar for case class method
  println(student3)
  //Case classes with pattern matching
  val studentDetails = student3 match {
    case Student(name, grade, section) => s"Student name: $name \nGrade: $grade \nSection: $section"
    case _ => "Student details not found."
  }
  println(studentDetails)
}

case class Student(name: String, grade: Int, section: Char)