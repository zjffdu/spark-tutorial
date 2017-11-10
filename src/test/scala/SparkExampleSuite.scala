package com.zjffdu.tutorial.spark

import java.io.OutputStream

import org.apache.spark.repl.{Main, SparkILoop}
import org.apache.spark.{SparkConf, SparkContext, SparkEnv, SparkFiles}
import org.scalatest.FunSuite

import scala.tools.nsc.Settings
import scala.tools.nsc.interpreter._


class SparkExampleSuite extends FunSuite {

  test("asic") {
    System.setProperty("scala.usejavacp", "true")

    new Thread() {
      override def run(): Unit = {
//        Console.setOut(new MyOutputStream)
        Main.main(Array.empty[String])
      }
    }.start()

    while (Main.interp == null) {
      println("waiting...")
      Thread.sleep(30000)
    }
//    val sparkILoop = Main.interp
////    sparkILoop.initializeSynchronous()
//    val reader = sparkILoop.in
//    val c = Main.sparkContext
//    System.out.println(c)

//    val settings = new Settings()
//    settings.processArguments(List("-Yrepl-class-based",
//      "-Yrepl-outdir", "/tmp/a"), true)
//    settings.usejavacp.value = true
//    settings.embeddedDefaults(Thread.currentThread().getContextClassLoader())
//
//    val sparkILoop = new SparkILoop(None, new JPrintWriter(Console.out, true))
//    sparkILoop.settings = settings
//    sparkILoop.createInterpreter()
//    sparkILoop.initializeSynchronous()
//
//    System.out.print(sparkILoop)
  }
}

class MyOutputStream extends OutputStream {
  override def write(b: Int): Unit = {
//    println()
  }
}



