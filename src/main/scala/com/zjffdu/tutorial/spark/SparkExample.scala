package com.zjffdu.tutorial.spark

import _root_.java.io.FileInputStream
import _root_.java.util.Properties

import org.apache.commons.io.IOUtils
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.Decimal
import org.apache.spark.storage.StorageLevel
import org.apache.spark._

import org.apache.spark.sql.types.Decimal
import scala.reflect.runtime.universe._

case class People(name: String, age: Int)

case class Trade(quantity: Decimal, price: Decimal)

/**
 * Created by jzhang on 7/30/15.
 */


object SparkExample {


  trait User {

  }

  class User1(val name: String) extends User

  class User2(val name: String) extends User

  object User1 {
    def unapply(u: User1): Option[String] = Some(u.name)
  }

  object User2 {
    def unapply(u: User2): Option[String] = Some(u.name)
  }

  object GivenNames {
    def unapplySeq(s: String): Option[(String, String, Seq[String])] = {
      val tokens = s.split("\\s")
      if (tokens.length < 2)
        None
      else
        Some(tokens(0), tokens(1), tokens.drop(2).toSeq)
    }
  }

  def collect[A, B](list: List[A])(pf: PartialFunction[A, B]): List[B] = {
    list.collect(pf)
  }

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("test").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd = sc.textFile("/user/jzhang/dataset/20news-bydate-train.txt")
    val wcrdd = rdd.flatMap(line=>line.split("\\s")).groupBy(e => 1, 2)
      //.map(e=>(e._1,e._2.size))


  }
}
