package com.zjffdu.tutorial.spark

import org.apache.spark._
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.attribute.{AttributeGroup, NumericAttribute, Attribute}
import org.apache.spark.ml.feature._
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.{Row, SQLContext}

/**
 * Created by jzhang on 8/10/15.
 */
object MLExample {

  def main(args:Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ml-example").setMaster("local[4]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    import sqlContext.implicits._

    val df = sqlContext.createDataFrame(Seq(
      (1.0, "hello world hadoop is"),
      (0.0, "apache hadoop"),
      (0.0, "apache spark i")
    )).toDF("label", "doc")

    val tokenizer = new RegexTokenizer()
      .setInputCol("doc")
      .setOutputCol("words")
      .setPattern("\\s")
      .setGaps(false)

    val pipeline = new Pipeline().setStages(Array(tokenizer))
    val model = pipeline.fit(df)

    model.transform(df).collect.foreach(println)
  }
}
