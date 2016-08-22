package com.zjffdu.tutorial.spark

import java.io.File

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{LogisticRegression, NaiveBayes}
import org.apache.spark.ml.evaluation.BinaryClassificationEvaluator
import org.apache.spark.ml.feature.{HashingTF, StopWordsRemover, Tokenizer}
import org.apache.spark.ml.tuning.{ParamGridBuilder, CrossValidator}
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by jzhang on 5/9/16.
 */
object NewsGroupsClassification {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("classification")
      .setMaster("local[*]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._
    import org.apache.spark.sql.functions._

    val rawRDD = sc.wholeTextFiles("file:///Users/jzhang/DataSet/20_newsgroups_small/*")
    val getLabel = (filename:String) => if (filename.contains("/alt.atheism/")) 0.0 else 1.0
    sqlContext.udf.register("getLabel", getLabel)
    val rawDF = rawRDD.toDF("filename", "text")
          .withColumn("label", expr("getLabel(filename)"))

    val splits = rawDF.randomSplit(Array(0.8,0.2))
    val trainDF = splits(0)
    val testDF = splits(1)

    val tokenizer = new Tokenizer()
      .setInputCol("text")
      .setOutputCol("raw_words")

    val stopWordsRemover = new StopWordsRemover()
      .setInputCol(tokenizer.getOutputCol)
      .setOutputCol("words")

    val hashTF = new HashingTF()
      .setInputCol(stopWordsRemover.getOutputCol)
      .setNumFeatures(1000)
      .setOutputCol("tf")

    // TODO word stemmer

    val classifier = new LogisticRegression()
      .setFeaturesCol("tf")
      .setLabelCol("label")
      .setMaxIter(100)

    val pipeline = new Pipeline()
      .setStages(Array(tokenizer, stopWordsRemover, hashTF, classifier))

    val cv = new CrossValidator()
    val paramsMap = new ParamGridBuilder()
      .addGrid(hashTF.numFeatures, Array(1000,2000,3000, 5000,100000))
      .addGrid(classifier.maxIter, Array(100,200))
      .build()

    cv.setEstimator(pipeline)
      .setEvaluator(new BinaryClassificationEvaluator())
      .setEstimatorParamMaps(paramsMap)
      .setNumFolds(3)

    val cvModel = cv.fit(trainDF)
    print(cvModel.explainParams())
    val testResult = cvModel.transform(testDF)
    testResult.show()
//    model.save("/Users/jzhang/Temp/a.model")
  }
}
