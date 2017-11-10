package com.zjffdu.tutorial.spark.udf;/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.spark.sql.api.java.UDF1;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Type;


public class MyUDF implements UDF1<String, String> {
  @Override
  public String call(String s) throws Exception {
    return s+ ".suffix";

  }

  public void f() {
//    getClass().getGenericSuperclass()
    Type[] types = getClass().getGenericInterfaces();
    for (Type type: types) {
      System.out.println(type);
      System.out.println(type.getClass());
      ParameterizedTypeImpl pType = ((ParameterizedTypeImpl)type);
      System.out.println(pType.getOwnerType());
      System.out.println(pType.getRawType());
      int n= pType.getActualTypeArguments().length;
       System.out.println(n);
    }
  }
  public static void main(String[] args) {

    new MyUDF().f();
  }
}
