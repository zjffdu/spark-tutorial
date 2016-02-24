package com.zjffdu.tutorial.spark;/*
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






import org.apache.log4j.Logger;


import java.util.LinkedList;
import java.util.List;

public class MyStack {

  private List<String> list = new LinkedList<>();
  private Logger LOGGER = Logger.getLogger(MyStack.class);

  public void push(String item) {
    LOGGER.info("push " + item);
    list.add(0, item);
  }

  public void pushAll(List<String> items) {
    for (String item : items) {
      this.push(item);
    }
  }

  public String pop() {
    LOGGER.info("Pop");
    return list.remove(0);
  }

  public String peek() {
    return list.get(0);
  }

  public List<String> getInternalList() {
    return this.list;
  }
}
