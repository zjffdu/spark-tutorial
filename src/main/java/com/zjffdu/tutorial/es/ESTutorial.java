package com.zjffdu.tutorial.es;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.HttpAsyncResponseConsumerFactory;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class ESTutorial {

  public static void main(String[] args) throws IOException {
    RestClient restClient = RestClient.builder(
        new HttpHost("localhost", 9200, "http")).build();

    Map<String, String> params = Collections.emptyMap();
    HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory consumerFactory =
        new HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory(30 * 1024 * 1024);
    Response response = restClient.performRequest("GET", "/posts/_search", params, null, consumerFactory);

    System.out.println(response);
    restClient.close();
  }
}
