package com.zjffdu.tutorial.scala

import java.sql.DriverManager
import java.text.SimpleDateFormat
import java.util.Date

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{Path, FileSystem}
import org.apache.spark.sql.catalyst.expressions.{Expression, NamedExpression}
import org.apache.spark.sql.catalyst.planning.PhysicalOperation._
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan

import scala.util.Try

/**
 * Created by jzhang on 5/6/15.
 */
object HelloWorld {


  sealed trait List[+A]

  case object Nil extends List[Nothing]

  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List {
    def sum(ints: List[Int]): Int = ints match {
      case Nil => 0
      case Cons(x, xs) => x + sum(xs)
    }

    def product(ds: List[Double]): Double = ds match {
      case Nil => 1.0
      case Cons(x, xs) => x * product(xs)
    }

    def foldRight[A, B](xs: List[A], b: B)(f: (A, B) => B): B = xs match {
      case Nil => b
      case Cons(h, t) => f(h, foldRight(t, b)(f))

    }

    def foldLeft[A, B](xs: List[A], b: B)(f: (B, A) => B): B = xs match {
      case Nil => b
      case Cons(h, t) => foldLeft(t, f(b, h))(f)
    }

    def tail[A](xs: List[A]): List[A] = xs match {
      case Cons(x, xs) => xs
    }

    def drop[A](xs: List[A], n: Int): List[A] = n match {
      case 0 => xs
      case n => drop(tail(xs), n - 1)
    }

    def dropWhile[A](xs: List[A])(f: A => Boolean): List[A] = xs match {
      case Nil => Nil
      case Cons(h, tail) => if (f(h)) dropWhile(tail)(f) else xs
    }

    def init[A](xs: List[A]): List[A] = xs match {
      case Nil => Nil
      case Cons(h, Nil) => Nil
      case Cons(h, t) => Cons(h, init(t))
    }

    //    def plugOne[A](xs : List[A]) : List[A] = xs match {
    //      case Nil => Nil
    //      case Cons(h, t) => Cons(h+1, plugOne(t))
    //    }

    def map[A, B](list: List[A])(f: A => B): List[B] = list match {
      case Nil => Nil
      case Cons(t, h) => Cons(f(t), map(h)(f))
    }

    def flatMap[A, B](list: List[A])(f: A => List[B]): List[B] = list match {
      case Nil => Nil
      case Cons(h, t) => f(h)
    }

    def apply[A](as: A*): List[A] =
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))


  }


  def main(args: Array[String]): Unit = {

    val conn = DriverManager.getConnection("jdbc:mysql://localhost","jzhang","")
    println(conn)
  }
}
