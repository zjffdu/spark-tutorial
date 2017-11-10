//package com.zjffdu.tutorial.spark
//
//import java.net.URL
//
//import org.apache.hadoop.security.UserGroupInformation
//import org.apache.spark.sql.hive.HiveContext
//import org.apache.spark.{SparkConf, SparkContext}
//import org.apache.spark.sql.{SQLContext, SaveMode}
//import org.apache.spark.sql.SparkSession
//import org.apache.spark.sql._
//import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
//import org.apache.spark.sql.functions._
//import org.apache.spark.sql.types._
//
///**
// * Created by jzhang on 8/6/15.
// */
//
//
//object SparkSQLExample {
//
//  class GeometricMean extends UserDefinedAggregateFunction {
//    // This is the input fields for your aggregate function.
//    override def inputSchema: org.apache.spark.sql.types.StructType =
//    StructType(StructField("value", DoubleType) :: Nil)
//
//    // This is the internal fields you keep for computing your aggregate.
//    override def bufferSchema: StructType = StructType(
//      StructField("count", LongType) ::
//        StructField("product", DoubleType) :: Nil
//    )
//
//    // This is the output type of your aggregatation function.
//    override def dataType: DataType = DoubleType
//
//    override def deterministic: Boolean = true
//
//    // This is the initial value for your buffer schema.
//    override def initialize(buffer: MutableAggregationBuffer): Unit = {
//      buffer(0) = 0L
//      buffer(1) = 1.0
//    }
//
//    // This is how to update your buffer schema given an input.
//    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
//      buffer(0) = buffer.getAs[Long](0) + 1
//      buffer(1) = buffer.getAs[Double](1) * input.getAs[Double](0)
//    }
//
//    // This is how to merge two objects with the bufferSchema type.
//    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
//      buffer1(0) = buffer1.getAs[Long](0) + buffer2.getAs[Long](0)
//      buffer1(1) = buffer1.getAs[Double](1) * buffer2.getAs[Double](1)
//    }
//
//    // This is where you output the final value, given the final value of your bufferSchema.
//    override def evaluate(buffer: Row): Any = {
//      math.pow(buffer.getDouble(1), 1.toDouble / buffer.getLong(0))
//    }
//  }
//
//  def main(args: Array[String]): Unit = {
//
//    val conf = new SparkConf().setMaster("local[4]").setAppName("test")
//    val sc = new SparkContext(conf)
//    val spark = SparkSession.builder().getOrCreate()
//
//    spark.udf.register("gm", new GeometricMean)
//
//    val df = spark.createDataFrame(Seq((1, "jeff"),(2, "andy"), (3, "jeff"))).toDF("id", "name")
//    df.registerTempTable("df")
//    val gm = new GeometricMean
//
//    // Show the geometric mean of values of column "id".
//    spark.sql("select name, gm(id) from df group by name").show()
//  }
//}
