package com.knoldus

object Implicits extends App {

  implicit val gravity: Double = 9.8

  private val energy = new PotentialEnergy
  private val mass = 50.0
  private val height = 20.0

  println( energy.calculatePotentialEnergy(mass, height))

}
class PotentialEnergy{
  def calculatePotentialEnergy(mass: Double, height: Double)(implicit gravity: Double): Double = {
    mass * height * gravity
  }
}
