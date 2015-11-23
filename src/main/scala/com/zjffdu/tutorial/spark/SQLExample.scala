package com.zjffdu.tutorial.spark

import org.apache.spark._
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.SQLContext

/**
 * Created by jzhang on 5/4/15.
 */
object SQLExample {

  case class Person(name:String, age:Int)

  def main(args:Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("SQLExample")
    val context = new SparkContext(conf)
    val sqlContext = new SQLContext(context)

    import sqlContext.implicits._

    val df = sqlContext.load("/Users/jzhang/github/spark/examples/src/main/resources/people.json", "json")
    df.select("name").collect() foreach println
  }
}
