package com.zjffdu.tutorial.java;

import com.google.gson.Gson;
import org.apache.http.client.config.RequestConfig;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Field;

/**
 * Created by jzhang on 10/20/16.
 */
public class JavaCompilerExample {

  public static class A {
    public String a;
    public String b;
  }

  public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {

    Gson gson = new Gson();
    A a = new A();
    a.a = "v";
    System.out.println(gson.toJson(a));
  }

}
