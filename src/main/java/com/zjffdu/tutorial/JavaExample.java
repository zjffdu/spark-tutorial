package com.zjffdu.tutorial;

import com.zjffdu.tutorial.spark.SparkExample$;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * Created by jzhang on 1/21/16.
 */
public class JavaExample {

    private static List<String> items = new ArrayList();

    public static class ReadThread extends Thread {

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                List<String> newItems = new ArrayList<>(items);
                for (String item : newItems) {
                    System.out.println(item);
                }
            }
        }
    }

    public static class UpdateThread extends Thread {
        @Override
        public void run() {
            while(true) {
//                try {
//                    Thread.sleep(70);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                items.add(new java.util.Random().nextInt(1000) + "");
            }
        }
    }

    public static void main(String[] args) {

        SparkExample$ a = SparkExample$.MODULE$;
        a.main(args);
    }
}
