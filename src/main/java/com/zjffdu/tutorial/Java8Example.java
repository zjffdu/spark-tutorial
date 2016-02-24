//package com.zjffdu.tutorial;/*
// * Licensed to the Apache Software Foundation (ASF) under one or more
// * contributor license agreements.  See the NOTICE file distributed with
// * this work for additional information regarding copyright ownership.
// * The ASF licenses this file to You under the Apache License, Version 2.0
// * (the "License"); you may not use this file except in compliance with
// * the License.  You may obtain a copy of the License at
// *
// *    http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Collections;
//
//
//public class Java8Example {
//
//  public interface MyInterface {
//    public void hello();
//
//    default void hello2() {
//      System.out.println("hello2");
//    }
//  }
//
//  public interface Converter<T,F> {
//    F convert(T t);
//  }
//
//
//  public static void main(String[] args) {
//    List<String> list = Arrays.asList("a", "b", "d", "c");
//    Collections.sort(list, (a,b) -> a.compareTo(b));
//
//    MyInterface in = new MyInterface() {
//      public void hello() {
//        System.out.println("hello");
//      }
//    };
//
//    in.hello();
//    in.hello2();
//
//    Converter<String,Integer> converter = Integer::valueOf;
//
//    converter.convert("12");
//
//    Integer i = new Integer(1);
//
//
//
//
//
//  }
//}
