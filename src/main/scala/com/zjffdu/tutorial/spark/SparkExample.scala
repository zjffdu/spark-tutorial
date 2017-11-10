package com.zjffdu.tutorial.spark

import java.io.{File, OutputStream}
import java.net.{URI, URISyntaxException}

import org.apache.spark.rdd.RDD
import org.apache.spark.repl.{Main, SparkILoop, SparkIMain}
import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext, SparkEnv, SparkFiles}

import scala.collection.mutable.Queue




object SparkExample extends App {

  val sparkConf = new SparkConf().setAppName("QueueStream").setMaster("local[*]")
  // Create the context
  val ssc = new StreamingContext(sparkConf, Seconds(1))

  // Create the queue through which RDDs can be pushed to
  // a QueueInputDStream
  val rddQueue = new Queue[RDD[Int]]()

  // Create the QueueInputDStream and use it do some processing
  val inputStream = ssc.queueStream(rddQueue)
  val mappedStream = inputStream.map(x => (x % 10, 1))
  val reducedStream = mappedStream.reduceByKey(_ + _)
  reducedStream.print()
  ssc.start()

  // Create and push some RDDs into rddQueue
  for (i <- 1 to 10) {
    rddQueue.synchronized {
      rddQueue += ssc.sparkContext.makeRDD(1 to 1000, 10)
    }
    Thread.sleep(1000)
  }
  ssc.stop()
}



