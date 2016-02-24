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


    sqlContext.udf.register("f", (a:Int, b:Option[Int]) =>{
      if (a==1 && !b.isDefined) {
        "Big"
      } else {
        "Small"
      }
    })

    val df =sqlContext.createDataFrame(Seq(
      (1,2),
      (2,3),
      (1,None)
    ))
    df.printSchema()
  }
}
