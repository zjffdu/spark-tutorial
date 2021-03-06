package com.zjffdu.tutorial.spark

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkContext, SparkConf}

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
object SparkHiveExample {

  def main(args:Array[String]): Unit = {
    val conf = new SparkConf().setAppName("example").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val hiveContext = new HiveContext(sc)
    hiveContext.createDataFrame(Seq((1,2),(2,3)))
    println(SQLContext.getOrCreate(sc))

  }
}
