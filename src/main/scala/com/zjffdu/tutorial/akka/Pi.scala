//package com.zjffdu.tutorial.akka
//
//import akka.actor._
//import akka.routing._
///**
// * Created by jzhang on 5/4/15.
// */
//object Pi {
//
//  case class GetResult(value: Double)
//  case object Caculate
//  case class CaculatePartial(start:Int, num:Int)
//  case class PartialResult(value: Double)
//
//
//  class Listener extends Actor {
//    def receive ={
//      case GetResult(value) =>
//        println("Result is:" + value)
//    }
//  }
//
//  class Master(numOfWorkers:Int, listener: ActorRef) extends Actor {
//
//    var pi:Double = 0
//    var numGetResults = 0
//    var workerRouter = context.actorOf(Props[Worker].withRouter(RoundRobinRouter(numOfWorkers)), name="worker")
//
//
//    def receive = {
//      case Caculate =>
//        for (i <- 1 to numOfWorkers) {
//          workerRouter ! CaculatePartial(i*25, 25)
//        }
//      case PartialResult(partialValue) =>
//        pi += partialValue
//        numGetResults = numGetResults +1
//        if (numGetResults == numOfWorkers) {
//          listener ! GetResult(pi)
//        }
//      case _ => unhandled()
//    }
//  }
//
//  class Worker extends Actor {
//
//    def receive = {
//      case CaculatePartial(start, num) =>
//        var sum = 0
//        for (i<- start to start+num) {
//          sum +=i
//        }
//        sender ! PartialResult(sum)
//      case _ =>
//        unhandled()
//    }
//  }
//
//  def main(args:Array[String]): Unit = {
//    val actorSystem = ActorSystem("Pi")
//    val listener = actorSystem.actorOf(Props[Listener], name="listener")
//    val master = actorSystem.actorOf(Props(new Master(2, listener)), name="master")
//    master ! Caculate
//
//  }
//}
