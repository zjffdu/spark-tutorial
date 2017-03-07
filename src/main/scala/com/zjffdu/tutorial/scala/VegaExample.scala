//package com.zjffdu.tutorial.scala
//
//
///**
//  * Created by jzhang on 11/23/16.
//  */
//object VegaExample {
//
//  def main(args: Array[String]): Unit = {
//    import vegas._
//    import vegas.render.WindowRenderer._
//
//    val plot = Vegas("Country Pop").
//      withData(
//        Seq(
//          Map("country" -> "USA", "population" -> 314),
//          Map("country" -> "UK", "population" -> 64),
//          Map("country" -> "DK", "population" -> 80)
//        )
//      ).
//      encodeX("country", Nom).
//      encodeY("population", Quant).
//      mark(Bar)
//
//    plot.show
//  }
//}
