//package com.zjffdu.tutorial.spark;/*
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
//import org.apache.hadoop.security.UserGroupInformation;
//import org.joda.time.DateTime;
//import org.joda.time.DateTimeZone;
//
//import java.io.File;
//import java.io.IOException;
//import java.security.PrivilegedAction;
//import java.security.PrivilegedExceptionAction;
//import java.util.Calendar;
//
//public class JavaExample {
//  public static void main(String[] args) throws IOException, InterruptedException {
//
//
//    try {
//      UserGroupInformation ugi = UserGroupInformation.createProxyUser("jeff", UserGroupInformation.getCurrentUser());
//      ugi.doAs(new PrivilegedExceptionAction<Void>() {
//
//        public Void run() throws IOException, InterruptedException {
//          try {
//
//            ProcessBuilder builder = new ProcessBuilder("/bin/bash").inheritIO();
//            Process proc = builder.start();
//            try {
//              proc.waitFor();
//            } catch (InterruptedException e) {
//              e.printStackTrace();
//            }
//          } catch (RuntimeException e) {
//            e.printStackTrace();
//          }
//          return null;
//        }
//      });
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//
//  }
//}
