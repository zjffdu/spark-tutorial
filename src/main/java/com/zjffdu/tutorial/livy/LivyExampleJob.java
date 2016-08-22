package com.zjffdu.tutorial.livy;

/**
 * Created by jzhang on 3/22/16.
 */
public class LivyExampleJob {

  public Integer run() {
    int sum = 0;
    for (int i=1;i<100;++i) {
      sum += i;
    }
    return sum;
  }
}
