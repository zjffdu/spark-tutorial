package com.zjffdu.tutorial.spark

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{SaveMode, SQLContext}

import org.apache.spark.sql.SQLContext._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._

/**
 * Created by jzhang on 8/6/15.
 */


object SparkSQLExample {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[4]").setAppName("test")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._
    import sqlContext._
    sqlContext.udf.register("f1", (a:Int) => a +1)
    val df1 = Seq(
      (1, "jeff", 12),
      (2, "andy", 34),
      (3, "pony", 23),
      (4, "jeff", 14)
    ).toDF("id", "name", "age")
    df1.registerTempTable("df1")
    val df2 = Seq(
      (1, "One"),
      (2, "Two")
    ).toDF("id", "ID")
    df2.registerTempTable("df2")
    df1.printSchema()
    df2.printSchema()

    df1.withColumn("age_new", $"f1(age)").show()
//    sqlContext.create
  }
}
