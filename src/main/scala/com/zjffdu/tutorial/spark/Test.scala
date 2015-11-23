package com.zjffdu.tutorial.spark


import _root_.java.lang.reflect.ParameterizedType

import org.apache.spark.SparkContext

import scala.collection.mutable.ArrayBuffer



object Test{
  def main(args:Array[String]): Unit = {

    val clazz = Class.forName("com.zjffdu.tutorial.spark.java.udf.MyUDF")

    val n=clazz.getGenericSuperclass.asInstanceOf[ParameterizedType].getActualTypeArguments().length
    println(n)
  }

}
