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
      (1, ("hello hadoop"),"P", Vectors.dense(1.0,0.0, 1.0)),
      (2, ("hello spark"), "N", Vectors.dense(1.2,1.0, 2.1)),
      (3, ("hello pig"), "P", Vectors.dense(1.5, 0.0, 2.4))
    )).toDF("id", "text", "category", "rawVector")

    val tokenizer = new Tokenizer()
      .setInputCol("text")
      .setOutputCol("tokens")

    val vectorIndexer = new VectorIndexer()
      .setInputCol("rawVector")
      .setOutputCol("newVector")
      .setMaxCategories(3)

    val model = vectorIndexer.fit(df)
    model.categoryMaps.foreach(println)
    model.transform(df).show(false)
  }
}
