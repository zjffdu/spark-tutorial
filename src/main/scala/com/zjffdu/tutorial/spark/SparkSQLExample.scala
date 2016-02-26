package com.zjffdu.tutorial.spark

import org.apache.spark.sql.hive.HiveContext
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


//    val df = hiveContext.read.orc("file:///Users/jzhang/github/spark/python/test_support/sql/orc_partitioned/b=0/c=0/part-r-00000-829af031-b970-49d6-ad39-30460a0be2c8.orc")

    val rdd = sc.parallelize(Seq(1, 10))
    val rdd2 = sc.parallelize(Seq("1","2"))


    val seq = Seq((1,"jeff", 23),(2,"andy", 25), (3,"jeff", 34))
    val seq2 = Seq((1, "cs"), (2, "math"))
    val df1 = seq.toDF("id", "name", "age")
    val df2 = seq2.toDF("id2", "major")

    df1.map(row=>row.get(0)).collect().foreach(println)
  }
}
