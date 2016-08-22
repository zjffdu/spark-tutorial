//package com.zjffdu.tutorial.livy;
//
///**
// * Created by jzhang on 3/22/16.
// */
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Future;
//
///**
// * Created by jzhang on 3/22/16.
// */
//public class LivyClientExample {
//  public static void main(String[] args) throws IOException, URISyntaxException, ExecutionException, InterruptedException {
//    LivyClient client = new LivyClientBuilder().setURI(new URI("http://localhost:8998")).build();
//    client.addJar(new URI("hdfs:///user/jzhang/spark-tutorial-1.0-SNAPSHOT.jar"));
//    Future<Integer> future = client.run(new Job<Integer>() {
//
//      @Override
//      public Integer call(JobContext jc) throws Exception {
//
//        return new LivyExampleJob().run();
//      }
//    });
//
//    System.out.println(future.get());
//  }
//}
