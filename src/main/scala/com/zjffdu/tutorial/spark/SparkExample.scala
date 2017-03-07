package com.zjffdu.tutorial.spark

import org.apache.spark.{SparkConf, SparkContext, SparkFiles}


object SparkExample {
  def main(args: Array[String]): Unit = {


    val conf = new SparkConf().setAppName("test")
    val sc = new SparkContext(conf)

    sc.parallelize( 1 to 10, 2).foreach(e => {
      println(SparkFiles.get("a.sh"))
//      println(SparkJars)
    })

  }
}

