package com.zjffdu.tutorial.java;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Field;

/**
 * Created by jzhang on 10/20/16.
 */
public class JavaCompilerExample {


  public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {

    File file1 = new File("/Users/jzhang/pig_udf_test.jar");
    File file2 = new File("/Users/jzhang/pig_udf_test2.jar");

    URLClassLoader loader = new URLClassLoader(new URL[]{file1.toURL(), file2.toURL()}, ClassLoader.getSystemClassLoader());
    Class clazz = loader.loadClass("org.apache.zeppelin.pig.test.Dummy");
    for (Field field : clazz.getDeclaredFields()) {
      System.out.println(field);
    }

    file1.delete();
    clazz = loader.loadClass("org.apache.zeppelin.pig.test.Dummy");
    for (Field field : clazz.getDeclaredFields()) {
      System.out.println(field);
    }

  }

}
