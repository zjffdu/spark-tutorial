package com.zjffdu.tutorial.spark

import _root_.java.util.Properties

import org.apache.hadoop.mapreduce.lib.input.TextInputFormat
import org.apache.spark.sql.SQLContext
import org.apache.spark.storage.StorageLevel
import org.apache.spark.{TaskContext, SparkConf, SparkContext}


case class People(name:String, age:Int)

/**
 * Created by jzhang on 7/30/15.
 */
object SparkExample {

  def main(args:Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Example")//.setMaster("local[4]")
      .set("spark.cores.max", "2")
      .set("spark.executor.cores","1")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val df =sqlContext.read.jdbc("jdbc:mysql://localhost/test","student",  new Properties())
    df.show()
  }
}
