package com.zjffdu.tutorial.spark

import java.net.URL

import org.apache.hadoop.security.UserGroupInformation
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
    import org.apache.spark.sql.functions._
    import scala.collection.JavaConverters._

    sc.parallelize(1 to 2)
      .flatMap(e=>UserGroupInformation.getCurrentUser.getTokens.asScala.map(_.toString))
      .collect() foreach println
  }
}
