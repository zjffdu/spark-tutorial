package com.zjffdu.tutorial.spark

/**
 * Created by jzhang on 6/15/15.
 */

import org.apache.spark._
import org.apache.spark.streaming._

object SparkStreamingExample {

  def main(args:Array[String]): Unit = {
    val conf = new SparkConf().setAppName("streaming example").setMaster("local[4]")
    val ssc = new StreamingContext(conf, Seconds(1))

    val input = ssc.socketTextStream("localhost",9999)
    val wc = input.flatMap(line=>line.split("\\s")).map(w=>(w,1)).reduceByKey(_ + _)
    wc.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
