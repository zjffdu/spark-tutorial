//package com.zjffdu.tutorial.spark.kaggle.crime
//
//import org.apache.spark.ml.feature.{OneHotEncoder, StringIndexer}
//import org.apache.spark.sql.SQLContext
//import org.apache.spark.{SparkContext, SparkConf}
//
///**
// * Created by jzhang on 5/27/16.
// */
//object SFCrime {
//
//  def main(args: Array[String]): Unit = {
//
//    val conf = new SparkConf().setAppName("SFCrime").setMaster("local[4]")
//    val sc = new SparkContext(conf)
//    val sqlContext = new SQLContext(sc)
//
////    val training = sqlContext.read
////      .format("com.databricks.spark.csv")
////      .option("header", "true")
////      .option("inferSchema", "true")
////      .load(args(0))
////
////
////    val stringIndexer = new StringIndexer()
////    stringIndexer.setInputCol("Category")
////    stringIndexer.setOutputCol("Category_i")
////
////    val model = stringIndexer.fit(training)
////    model.transform(training).show(20)
//
//    val df = sqlContext.createDataFrame(Seq(
//      (0, "a"),
//      (1, "b"),
//      (2, "c"),
//      (3, "a"),
//      (4, "a"),
//      (5, "c")
//    )).toDF("id", "category")
//
//    val indexer = new StringIndexer()
//      .setInputCol("category")
//      .setOutputCol("categoryIndex")
//      .fit(df)
//    val indexed = indexer.transform(df)
//
//    val encoder = new OneHotEncoder()
//      .setInputCol("categoryIndex")
//      .setOutputCol("categoryVec")
//    val encoded = encoder.transform(indexed)
//    encoded.select("id", "categoryVec").show()
//  }
//}
