package com.zjffdu.tutorial.spark

import org.apache.spark.annotation.DeveloperApi
import org.apache.spark.ml.Transformer
import org.apache.spark.ml.attribute.AttributeGroup
import org.apache.spark.ml.feature._
import org.apache.spark.ml.param.{Param, ParamMap}
import org.apache.spark.mllib.classification.{LogisticRegressionWithLBFGS, NaiveBayes, LogisticRegressionWithSGD, SVMWithSGD}
import org.apache.spark.mllib.evaluation.{MulticlassMetrics, BinaryClassificationMetrics}
import org.apache.spark.mllib.fpm.FPGrowth
import org.apache.spark.mllib.linalg.{DenseMatrix, Matrix, Vectors, Matrices}
import org.apache.spark.mllib.regression.{LabeledPoint, LassoWithSGD, LinearRegressionWithSGD}
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
//    val sqlContext = new SQLContext(sc)



    val rdd = sc.textFile("/Users/jzhang/Java/lib/spark-1.6.1/data/mllib/sample_fpgrowth.txt")
      .map(line=>line.split("\\s"))

    val fpGrowth = new FPGrowth()
    fpGrowth.setMinSupport(0.2)
    fpGrowth.setNumPartitions(10)

    val fpModel = fpGrowth.run(rdd)
    fpModel.freqItemsets.foreach(itemSet=>{
      println(itemSet.items.mkString(",") + "==>" + itemSet.freq)
    })

    fpModel.generateAssociationRules(0.5).foreach(rule=>{
      println(rule.antecedent.mkString(",") + "=>" + rule.consequent.mkString(",") +", confident:" + rule.confidence)
    })
  }
}
