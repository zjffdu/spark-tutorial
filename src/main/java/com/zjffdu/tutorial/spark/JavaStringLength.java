package com.zjffdu.tutorial.spark;

import org.apache.spark.sql.api.java.UDF1;

/**
 * Created by jzhang on 1/12/17.
 */
public class JavaStringLength implements UDF1<String,Integer> {
  @Override
  public Integer call(String s) throws Exception {
    return s.length();
  }
}
