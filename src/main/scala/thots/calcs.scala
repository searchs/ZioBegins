package com.katchfashion.nyltics
package thots

import scala.util.Random


/** *
 * Rules to build by:
 *   1. A pure function must be total
 *      2.  A pure function must be deterministic and must depend only on its inputs
 *      3. A pure function must not have side effects
 *      -- e.g. (a) memory mutations,
 *      (b) interactions with the outside world, such as printing messages to the console, calling an external API, querying a database.
 *
 *
 */
object calcs extends App {

  def simpleDivide(a: Int, b: Int): Int = a / b

  println(simpleDivide(4, 2)) //println is a side effect  - use logger!!!!
  //  println(simple_divide(5, 0)) // Expect java.lang.ArithmeticException: / by zero

  /**
   * Transform the partial function into a total function
   *
   * @param a
   * @param b
   * @return
   */
  private def divideFuncWay(a: Int, b: Int): Option[Int] = {
    if (b != 0) Some(a / b) else None
  }

  println(divideFuncWay(5, 0)) // Handles java.lang.ArithmeticException: / by zero -- by nature


  /**
   * Non-deterministic.  Not ideal in functional programming
   * -  result can NEVER is certain in this function.  AVOID!!!
   *
   * @return
   */
  def generateRandomInt(): Int = (new Random()).nextInt()

  println(generateRandomInt())


  final case class RNG(seed: Long) {
    def nextInt: (Int, RNG) = {
      val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
      val nextRNG = RNG(newSeed)
      val n = (newSeed >>> 16).toInt
      (n, nextRNG)
    }
  }


  /**
   * Sample pure function
   * More deterministic random generator
   *
   * @param random
   * @return
   */
  def generateRandomInt(random: RNG): (Int, RNG) = random.nextInt

  val random = RNG(10)

  val (n1, random1) = generateRandomInt(random)
  val (n2, random2) = generateRandomInt(random)


  println(s"N1: $n1 => RND1: $random1")
  println(s"N2: $n2 => RND2: $random2")


  //  More Examples of NON-FP coding

  var a = 0

  def increment(inc: Int): Int = {
    a += inc
    a
  }

  def add(a: Int, b: Int): Int = {
    println(s"Adding two integers $a and $b") // using println writes to the console!!!!
    a + b
  }


}

