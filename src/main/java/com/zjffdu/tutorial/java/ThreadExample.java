package com.zjffdu.tutorial.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by jzhang on 10/14/16.
 */
public class ThreadExample {

  private static Logger LOGGER = LoggerFactory.getLogger(ThreadExample.class);

  public static class Thread3 extends Thread {

    Map<String, List<String>> map;

    public Thread3(Map<String, List<String>> map) {
      this.map = map;
    }

    @Override
    public void run() {
      while(true) {
        try {
          Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (map) {
          List<String> list = map.get("key");
          if (list != null) {
            for (String item : list) {
              System.out.println(item);
            }
          }
        }
      }
    }
  }

  public static class Thread2 extends Thread {
    Map<String, List<String>> map;

    public Thread2(Map<String, List<String>> map) {
      this.map = map;
    }

    @Override
    public void run() {
      while(true) {
        try {
          Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (map) {
          List<String> list = map.get("key");
          if (list != null) {
            if (new Random().nextBoolean() || list.isEmpty()) {
              list.add("value_" + UUID.randomUUID());
            } else {
              list.remove(0);
            }
          } else {
            map.put("key", new LinkedList<String>());
          }
        }
      }
    }
  }


  public static void main(String[] args) {

    Map<String, List<String>> map = new HashMap<>();
//    new Thread2(map).start();
//    new Thread3(map).start();

    LOGGER.debug("Call rest api in {}, method: {}, jsonData: {}", null, null, null);

  }
}
