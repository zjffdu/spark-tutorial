//package com.zjffdu.tutorial.spark.datacastle
//
//import org.apache.spark.ml.Pipeline
//import org.apache.spark.ml.classification.{NaiveBayes, LogisticRegression}
//import org.apache.spark.ml.evaluation.BinaryClassificationEvaluator
//import org.apache.spark.ml.feature.VectorAssembler
//import org.apache.spark.mllib.linalg.Vectors
//import org.apache.spark.sql.SQLContext
//import org.apache.spark.{SparkContext, SparkConf}
//import org.apache.spark.mllib.regression.LabeledPoint
///*
// * Licensed to the Apache Software Foundation (ASF) under one or more
// * contributor license agreements.  See the NOTICE file distributed with
// * this work for additional information regarding copyright ownership.
// * The ASF licenses this file to You under the Apache License, Version 2.0
// * (the "License"); you may not use this file except in compliance with
// * the License.  You may obtain a copy of the License at
// *
// *    http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//object DataCastle {
//
//  def main(args:Array[String]): Unit = {
//    val conf = new SparkConf().setAppName("test").setMaster("local")
//    val sc = new SparkContext(conf)
//    val sqlContext = new SQLContext(sc)
//
//    import sqlContext.implicits._
//
//    val dataX = "/Users/jzhang/Downloads/DataCastle/train_x.csv"
//    val dataY = "/Users/jzhang/Downloads/DataCastle/train_y.csv"
//    val dfX = sqlContext.read.format("csv").option("header", "true").option("inferSchema", "true").load(dataX)
//    val dfY = sqlContext.read.format("csv").option("header", "true").option("inferSchema", "true").load(dataY)
//    val df = dfX.join(dfY, "uid").withColumn("y", $"y".cast("double"))
//    val dfsplits =df.randomSplit(Array(0.7,0.3))
//    val dfTrain = dfsplits(0)
//    val dfTest = dfsplits(1)
//
//    val inputFeatures = (1 to 1138).map("x" + _ ).toArray
//
//    val transformer1 = new VectorAssembler()
//      .setInputCols(inputFeatures)
//      .setOutputCol("features")
//
//    val lr = new LogisticRegression()
//      .setMaxIter(15)
//      .setRegParam(0.01)
//      .setStandardization(true)
//      .setLabelCol("y")
//      .setFeaturesCol("features")
//
//    val nb = new NaiveBayes()
//      .setLabelCol("y")
//      .setFeaturesCol("features")
//
//    val pipeline = new Pipeline()
//      .setStages(Array(transformer1, nb))
//
//    val model = pipeline.fit(dfTrain)
//
//    val dfEval = model.transform(dfTest)
//      .select("y", "probability", "rawPrediction", "prediction")
//
//    dfEval.printSchema()
//
//    val binaryClassEvaluator = new BinaryClassificationEvaluator()
//      .setLabelCol("y")
//      .setRawPredictionCol("rawPrediction")
////
//    println(binaryClassEvaluator.evaluate(dfEval))
////    val pipeline = new Pipeline
////    dfTrain.map(row=> (row.getAs[Double]("y"), Vectors.dense))
//  }
//}
