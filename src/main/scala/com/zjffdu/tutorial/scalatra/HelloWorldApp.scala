//package com.zjffdu.tutorial.scalatra
//
//import javax.servlet.ServletContext
//
//import org.scalatra.ScalatraFilter
//import org.scalatra._
//
///**
// * Created by jzhang on 3/11/16.
// */
//class HelloWorldApp extends ScalatraServlet {
//
//  get("/") {
//    <h1> Hello, World</h1>
//  }
//}
//
//class ScalatraBootstrap extends LifeCycle {
//  override def init(context: ServletContext) {
//    context.mount(new HelloWorldApp, "/*")
//  }
//}
