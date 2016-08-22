package com.zjffdu.tutorial.spark

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.hadoop.io.Text
import org.apache.hadoop.io.compress.SnappyCodec
import org.apache.hadoop.mapred.SequenceFileOutputFormat
import org.apache.spark.{SparkConf, SparkContext, TaskContext}


object SparkExample {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("test").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(1 to 10, 10)
    val result = sc.runJob(rdd, { (ctx: TaskContext, iter: Iterator[Int]) => return; 1 } )

  }
}

