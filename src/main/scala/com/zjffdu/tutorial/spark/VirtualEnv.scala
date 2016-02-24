package com.zjffdu.tutorial.spark

import java.io.{IOException, BufferedReader, InputStreamReader, InputStream}
import java.util.Arrays

import scala.io.Source

/**
 * Created by jzhang on 1/28/16.
 */
object VirtualEnv {

  class StreamGobbler(is: InputStream, isError: Boolean) extends Thread {

    override def run(): Unit = {
      try {
        val isr = new InputStreamReader(is);
        val br = new BufferedReader(isr);
        var line: String = null;
        val lines = Source.fromInputStream(is).bufferedReader().lines()
        lines.toArray.foreach(println)
      } catch {
        case ioe: IOException => ioe.printStackTrace();
      }
    }
  }

  def main(args: Array[String]): Unit = {

//    val pb = new ProcessBuilder(Arrays.asList("virtualenv", "-p",
//      "/Library/Frameworks/Python.framework/Versions/2.7/bin/python",
//      "--no-site-packages", "python_virtualenv_1"))
    val pb = new ProcessBuilder(Arrays.asList("/Users/jzhang/Java/lib/hadoop-2.6.0/test.sh"))
    val workerEnv = pb.environment()
    val p = pb.start()
    val err = p.getErrorStream
    val out = p.getInputStream
    new StreamGobbler(err, true).start()
    new StreamGobbler(out, false).start()
    val exitCode = p.waitFor()

  }
}
