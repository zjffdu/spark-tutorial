package com.zjffdu.tutorial.hive;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

/**
 * Created by jzhang on 1/26/16.
 */
public class SimpleUDF extends UDF{
  public Text evaluate(Text input) {
    return new Text("Hello " + input.toString());
  }
}
