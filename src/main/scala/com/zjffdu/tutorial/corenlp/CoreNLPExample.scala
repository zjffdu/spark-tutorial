//package com.zjffdu.tutorial.corenlp
//
///**
// * Created by jzhang on 3/1/16.
// */
//import java.util.Properties
//
//import edu.stanford.nlp.pipeline.{Annotation, StanfordCoreNLP}
//import edu.stanford.nlp.simple.Sentence
//import scala.collection.JavaConverters._
//
//object CoreNLPExample {
//
//  def main(args: Array[String]): Unit = {
//
//    val props = new Properties();
////    props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
////    val pipeline = new StanfordCoreNLP(props);
//
//    val sentence = new Sentence("今天我很开心")
//    sentence.words().asScala foreach println
//
//  }
//}
