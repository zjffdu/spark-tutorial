package com.zjffdu.tutorial;



import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.LogOutputStream;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.RawLocalFileSystem;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.spark.SecurityManager;
import org.apache.spark.SparkConf;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.tools.ant.taskdefs.Java;
import org.apache.zeppelin.python.IPythonInterpreter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class JavaExample {


  private static Logger LOGGER = LoggerFactory.getLogger(JavaExample.class);

  public static class B{

  }

  public static class D extends B{

  }

  public static int f() {
    try {
      System.out.println("try....");
      return 1;
    } finally {
      System.out.println("finally....");
    }
  }
  public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, TTransportException {
    TServerSocket server1 = new TServerSocket(new InetSocketAddress("0.0.0.0", 9803));
    TServerSocket server2 = new TServerSocket(10010);
  }
}