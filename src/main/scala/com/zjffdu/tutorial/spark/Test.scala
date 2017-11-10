package com.zjffdu.tutorial.spark


import _root_.java.lang.reflect.{Modifier, ParameterizedType}

import org.apache.spark.SparkContext

import scala.collection.mutable.ArrayBuffer


class A {

  val d : Double = 0.0
  def getD():Double = 1.0

  def f() = {
    val methods = this.getClass.getMethods
    methods.filter { m =>
      Modifier.isPublic(m.getModifiers) &&
        classOf[Double].isAssignableFrom(m.getReturnType) &&
        m.getParameterTypes.isEmpty
    }.sortBy(_.getName)
      .map(m => m.invoke(this).asInstanceOf[Double])
  }
}

object Test{
  def main(args:Array[String]): Unit = {

    import collection.JavaConverters._
    import collection.mutable._
    val jul: java.util.List[Int] = ArrayBuffer(1, 2, 3).asJava

    jul.asScala

  }

}
