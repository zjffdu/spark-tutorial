package com.zjffdu.tutorial.spark

import org.apache.spark.annotation.DeveloperApi
import org.apache.spark.ml.Transformer
import org.apache.spark.ml.attribute.AttributeGroup
import org.apache.spark.ml.feature._
import org.apache.spark.ml.param.{Param, ParamMap}
import org.apache.spark.mllib.classification.{NaiveBayes, LogisticRegressionWithSGD, SVMWithSGD}
import org.apache.spark.mllib.evaluation.{MulticlassMetrics, BinaryClassificationMetrics}
import org.apache.spark.mllib.linalg.{Vectors, Matrices}
import org.apache.spark.mllib.regression.{LassoWithSGD, LinearRegressionWithSGD}
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.sql.{DataFrame, SQLContext}
import org.apache.spark.sql.types.{DataTypes, StructType}
import org.apache.spark.{SparkContext, SparkConf}

import org.apache.spark.mllib.clustering.KMeans


object MLlibExample {

  def main(args:Array[String]): Unit = {
    val conf = new SparkConf().setAppName("MLlibExample").setMaster("local[4]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)


    val df = sqlContext.sparkContext.textFile("file:///Users/jzhang/github/spark/data/mllib/kmeans_data.txt")
      .map(line=>{
        Vectors.dense(line.split("\\s").map(_.toDouble))
      })
    df.foreach(println)

    val model = KMeans.train(df,2,10)
    model.clusterCenters.foreach(println)
  }
}
