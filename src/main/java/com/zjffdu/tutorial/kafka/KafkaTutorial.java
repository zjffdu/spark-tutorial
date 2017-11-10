package com.zjffdu.tutorial.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class KafkaTutorial {

  private static Logger log = LoggerFactory.getLogger(KafkaTutorial.class);

  private static class DemoProducerCallback implements Callback {
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
      System.out.println("Partition:" + recordMetadata.partition() + ", offset:" + recordMetadata.offset());
      if (e != null) {
        e.printStackTrace();
      }
    }
  }

  private static void produce() throws InterruptedException {
    Properties kafkaProps = new Properties();
    kafkaProps.put("bootstrap.servers", "localhost:9092");
    kafkaProps.put("key.serializer",
        "org.apache.kafka.common.serialization.StringSerializer");
    kafkaProps.put("value.serializer",
        "org.apache.kafka.common.serialization.StringSerializer");
    KafkaProducer producer = new KafkaProducer<String, String>(kafkaProps);

    while(true) {
      ProducerRecord<String, String> record =
          new ProducerRecord<>("CustomerCountry", "Precision Products",
              "France");
      try {
        producer.send(record, new DemoProducerCallback());
      } catch (Exception e) {
        e.printStackTrace();
      }
      Thread.sleep(1000);
    }
  }

  private static void consume() {
    Properties props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    props.put("group.id", "CountryCounter");
    props.put("key.deserializer",
        "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer",
        "org.apache.kafka.common.serialization.StringDeserializer");
    KafkaConsumer<String, String> consumer = new KafkaConsumer<String,
        String>(props);
    consumer.subscribe(Collections.singletonList("CustomerCountry"));

    Map<String, Integer> custCountryMap = new HashMap<>();

    try {
      while (true) {
        ConsumerRecords<String, String> records = consumer.poll(00);
        for (ConsumerRecord<String, String> record : records) {
          log.info("topic = {}, partition = {}, offset = {}, customer = {}, country = {}\n",
              record.topic(), record.partition(), record.offset(),
              record.key(), record.value());
          int updatedCount = 1;
          if (custCountryMap.containsKey(record.value())) {
            updatedCount = custCountryMap.get(record.value()) + 1;
          }
          custCountryMap.put(record.value(), updatedCount);
          JSONObject json = new JSONObject(custCountryMap);
          System.out.println(json.toString(4));
        }
      }
    } finally {
      consumer.close();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    new Thread(){
      @Override
      public void run() {
        try {
          produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }.start();

    consume();
  }
}
