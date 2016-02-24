package com.zjffdu.tutorial.scala

import java.net.URI
import java.sql.DriverManager
import java.text.SimpleDateFormat
import java.util.{TimeZone, Calendar, Date}


import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{Path, FileSystem}
import org.apache.hadoop.io.compress.CompressionCodecFactory
import org.apache.spark.{SparkContext, SparkConf, Logging}
import org.apache.spark.sql.catalyst.expressions.{Expression, NamedExpression}
import org.apache.spark.sql.catalyst.planning.PhysicalOperation._
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.joda.time.{DateTimeZone, DateTime}

import scala.collection.mutable.ListBuffer
import scala.concurrent.Future
import scala.util.{Failure, Success, Random, Try}



object HelloWorld extends Logging {



  def f(a: Option[String]): Unit = {
    a.flatMap(codecClassName => {
      val codecFactory = new CompressionCodecFactory(new Configuration())
      val codecClass = Manifest.classType(codecFactory.getCodecClassByName(codecClassName))
      if (codecClass == null) {
        throw new RuntimeException("Unknown or not supported codec:" + codecClassName)
      }
      Some(codecClass)
    })
  }

  def main(args: Array[String]): Unit = {

    f(Some("a"))
    import sys.process._
    "echo 'hello'" !
  }


}
