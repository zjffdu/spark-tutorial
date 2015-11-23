package com.zjffdu.tutorial.spark

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.SparkContext._

/**
 * Created by jzhang on 5/1/15.
 */
object PageRank {

  def main(args:Array[String]): Unit = {
    val links = Array(("A", Array("B","C")), ("B", Array("C")), ("C", Array("A")))
    val ranks = Array(("A",1.0), ("B", 1.0), ("C", 1.0))

    val conf = new SparkConf().setAppName("PageRank").setMaster("local")
    val context = new SparkContext(conf)

    val linksRDD = context.parallelize(links)
    var ranksRDD = context.parallelize(ranks).map(e=>(e._1,e._2)).repartition(2)

    for (i<-1 to 10) {
      val contrib = linksRDD.join(ranksRDD, 2)
        .flatMap {
        case (url, (links, rank)) => links.map(link => (link, rank/links.size))
      }
      contrib.cache()
      ranksRDD = contrib.reduceByKey(_ + _, 2).mapValues(0.15 + 0.85 * _)
    }

    ranksRDD.collect().foreach(println)

    Thread.sleep(1000*1000)
  }
}
