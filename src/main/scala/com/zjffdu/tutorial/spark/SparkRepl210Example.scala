package com.zjffdu.tutorial.spark

import java.io.{File, PrintWriter}
import java.net.URLClassLoader

import org.apache.spark.repl.{Main, SparkILoop}

import scala.collection.mutable.ArrayBuffer
import scala.tools.nsc.interpreter.InteractiveReader

/**
  * Created by jzhang on 7/19/17.
  */
object SparkRepl210Example {

  def main(args: Array[String]): Unit = {

      System.setProperty("spark.master", "local")
      System.setProperty("scala.usejavacp", "true")
      var sparkILoop: SparkILoop = null
      var reader: InteractiveReader = null

      new Thread() {
        override def run(): Unit = {
  //        Console.setOut(interpOut)
          Main.main(Array.empty[String])
          //        sparkILoop = new SparkILoop(None, new PrintWriter(interpOut, true))
          //        callPrivate(Main, "doMain", Array("-classpath", classpath), sparkILoop)
        }
      }.start()


      Thread.sleep(30000)
      sparkILoop = Main.interp
//      reader = sparkILoop.in
  }
}
