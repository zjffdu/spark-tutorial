package com.zjffdu.tutorial.spark

import java.security.PrivilegedExceptionAction

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.hadoop.security.UserGroupInformation
/**
  * Created by jzhang on 8/22/16.
  */
object ImpersonationExample {

  def main(args: Array[String]): Unit = {
    val ugi = UserGroupInformation.createProxyUser("jeff", UserGroupInformation.getLoginUser)

    ugi.doAs(new PrivilegedExceptionAction[Void] {
      def run(): Void = {
        val fs = FileSystem.get(new Configuration())
        fs.globStatus(new Path(".")).foreach(println(_))
        println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
        val processBuilder = new ProcessBuilder()
        processBuilder.environment()
        processBuilder.command("/Users/jzhang/Java/lib/hadoop-2.7.2/bin/hadoop", "fs", "-ls", ".")
        processBuilder.inheritIO()
        val proc = processBuilder.start()
        proc.waitFor()
        return null
      }
    })
  }
}
