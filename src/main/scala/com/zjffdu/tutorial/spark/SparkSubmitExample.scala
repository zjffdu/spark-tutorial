package com.zjffdu.tutorial.spark

import org.apache.spark.deploy.SparkSubmit

/**
 * Created by jzhang on 7/30/15.
 */
object SparkSubmitExample {
  def main(args:Array[String]): Unit = {
    val args = Array("--master", "yarn-client",
      "--verbose",
      "--class",  "org.apache.spark.examples.SparkPi",
//      "--num-executors", "2",
//      "--executor-cores", "2",
//      "--executor-memory", "512",
      "--conf", "spark.yarn.jar=/Users/jzhang/github/spark/assembly/target/scala-2.10/spark-assembly-1.5.0-SNAPSHOT-hadoop2.6.0.jar",
      "/Users/jzhang/Java/lib/spark-src/examples/target/spark-examples_2.10-1.5.0-SNAPSHOT.jar", "10")
    SparkSubmit.main(args)

//    Class.forName("org.apache.spark.deploy.yarn.Client")
//    Class.forName("org.apache.spark.deploy.SparkSubmit")
  }

}
