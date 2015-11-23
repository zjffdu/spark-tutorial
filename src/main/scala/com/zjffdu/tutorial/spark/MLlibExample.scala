package com.zjffdu.tutorial.spark

import org.apache.spark.mllib.classification.{NaiveBayes, LogisticRegressionWithSGD, SVMWithSGD}
import org.apache.spark.mllib.evaluation.{MulticlassMetrics, BinaryClassificationMetrics}
import org.apache.spark.mllib.linalg.{Matrices, Vectors}
import org.apache.spark.mllib.regression.{LassoWithSGD, LinearRegressionWithSGD}
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkContext, SparkConf}

import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors

/**
 * Created by jzhang on 10/11/15.
 */
object MLlibExample {

  def main(args:Array[String]): Unit = {
    val conf = new SparkConf().setAppName("MLlibExample")//.setMaster("local[4]")
    val sc = new SparkContext(conf)

    val data = MLUtils.loadLibSVMFile(sc, args(0))
    val model = NaiveBayes.train(data)

    val prediction = model.predict(data.map(_.features))
    val metrics = new BinaryClassificationMetrics(prediction.zip(data.map(_.label)))
    println(metrics.areaUnderPR())
    println(metrics.areaUnderROC())

  }
}
