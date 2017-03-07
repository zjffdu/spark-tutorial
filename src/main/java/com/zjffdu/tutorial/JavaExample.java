package com.zjffdu.tutorial;


import org.apache.hadoop.security.UserGroupInformation;
import org.apache.spark.SecurityManager;
import org.apache.spark.SparkConf;

import java.io.IOException;

public class JavaExample {

  public static String f() {
    try {
      return "1";
    } finally {
      System.out.println("2");
    }
  }
  public static void main(String[] args) throws IOException {

    UserGroupInformation ugi = UserGroupInformation.getCurrentUser();
    UserGroupInformation ugi2 = UserGroupInformation.getLoginUser();

    System.out.println(ugi);
    System.out.println(ugi2);
  }
}