package com.zjffdu.tutorial.hcc


import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession



object HCCExample {

  case class Post(body: String, creation_date: String, id: Long, tags: Array[String], title: String, track_id: Long, track_name: String)


  def main(args: Array[String]) {
    //    val sc = new SparkContext(conf)
    val spark = SparkSession.builder().appName("hcc").master("local").getOrCreate()

    import spark.implicits._

    val rawData = spark.read.json("file:///Users/jzhang/github/datasets/hcc-pulic-dataset").as[Post]
    rawData.createOrReplaceTempView("posts")
    val tags = rawData.flatMap(_.tags).withColumnRenamed("value", "tag")
    tags.createOrReplaceTempView("tags");
    tags.printSchema()
//    spark.sql("select track_name, count(1) from posts group by track_name").show(100, truncate = false)

    spark.sql("select tag, count(1) as c from tags group by tag order by c desc").show(100, truncate = false)
//    rawData.head(10).foreach(p => {
//      println("Title:" + p.title)
//      println("Body:" + p.body)
//      println("Tags:" + p.tags)
//      println("++++++++++++++++++++++++++++++++++++++++++")
//    })
  }

}
