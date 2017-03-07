//package com.zjffdu.tutorial.scala
//
//import java.io.{BufferedReader, File, FileInputStream, PrintWriter}
//import java.lang.reflect.{ParameterizedType, Type}
//import java.net.URI
//import java.sql.DriverManager
//import java.text.SimpleDateFormat
//import java.util.concurrent.TimeUnit
//import java.util.{Calendar, Date, Properties, TimeZone}
//
//import com.ning.http.client.{AsyncCompletionHandler, AsyncHttpClient, Response}
//import com.zjffdu.tutorial.spark.Test
//import com.zjffdu.tutorial.spark.udf.MyUDF
//import org.apache.hadoop.conf.Configuration
//import org.apache.hadoop.fs.{FileSystem, Path}
//import org.apache.hadoop.io.compress.CompressionCodecFactory
//import org.apache.hadoop.security.SecurityUtil
//import org.apache.spark.repl.SparkILoop
//import org.apache.spark.{SparkConf, SparkContext}
//import org.apache.spark.sql.catalyst.expressions.{Expression, NamedExpression}
//import org.apache.spark.sql.catalyst.planning.PhysicalOperation._
//import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
//import org.joda.time.{DateTime, DateTimeZone}
//
//import scala.collection.mutable.ListBuffer
//import scala.concurrent.duration.Duration
//import scala.concurrent.{Await, Future}
//import scala.util.{Failure, Random, Success, Try}
//import scala.concurrent.ExecutionContext.Implicits.global
//
//class Test{
//
//}
//object HelloWorld {
//
//  def run(time: Long): Future[Int] = {
//    Future {
//      Thread.sleep(Random.nextInt(100))
//      Random.nextInt(10)
//    }
//  }
//
//  def main(args: Array[String]): Unit = {
//
//
//    def isUDFInterface(t: Type): Unit = {
//      if (t.isInstanceOf[ParameterizedType]) {
//        val pType = t.asInstanceOf[ParameterizedType]
//        println(pType.getRawType.asInstanceOf[Class[_]].getCanonicalName)
//      }
//    }
//
//
//  }
//
//
//
//}
