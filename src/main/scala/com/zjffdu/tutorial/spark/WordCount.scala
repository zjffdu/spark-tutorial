package com.zjffdu.tutorial.spark


import _root_.java.net.InetAddress

import org.apache.commons.io.IOUtils
import org.apache.log4j.Logger
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.SparkContext._
import scala.collection.JavaConversions._
import scala.util.Random

/**
 * Created by jzhang on 5/1/15.
 */
object WordCount {

  def main(args:Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Test")
        .setMaster("local[2]").setAppName("test")
//      .setMaster("spark://jzhangMBPr.local:7077")
//      .setJars(Array("/Users/jzhang/IdeaProjects/spark-tutorial/target/original-spark-tutorial-1.0-SNAPSHOT.jar"))
//      .set("spark.eventLog.enabled", "true")
//      .set("spark.eventLog.dir","/Users/jzhang/Temp/sparkEventLog")

    val sc = new SparkContext(conf)
//    sc.textFile("")
//    .map(line=> line.replaceAll("\|\+\|", "\t"))
//    .saveAsTextFile("")
    sc.parallelize(List("hello|+|abc"))
    .map(line=>line)
    .collect()
    .foreach(println)
    println(sc.defaultMinPartitions)
  }
}
