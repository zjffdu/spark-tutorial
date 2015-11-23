package com.zjffdu.tutorial.akka

/**
 * Created by jzhang on 5/3/15.
 */


import akka.actor._


sealed abstract class Direction
case object FORWARD extends Direction
case object BACKWARDS extends Direction
case object RIGHT extends Direction
case object LEFT extends Direction

case class Move(direction: Direction)
case object Stop
case object GetRobotState
case class RobotState(direction:Direction, moving: Boolean)

case object StartChildBots


class RobotChildActor extends Actor {

  def receive = {
    case Move(newDirection) =>
      println("Move to " + newDirection)
  }
}

class RobotActor extends Actor {

  var direction: Direction = FORWARD
  var moving:Boolean = false

  for (index <- 1 to 10) {
    context.actorOf(Props[RobotChildActor])
  }

  def receive = {
    case Move(newDirection) =>
      moving = true
      direction = newDirection
      println(s"I am now moving $direction")
      println("sender:" + sender())
      println("sender:" + self)
      sender ! "I got it"

    case StartChildBots =>
      context.children.foreach(child => {
        println(s"child = $child")
        child ! Move(FORWARD)
      })
      println("Master has started all children bots")

    case Stop =>
      moving = false
      println(s"I stopped moving")

    case msg => unhandled(msg)
  }
}

object RobotActor {
  def main(args:Array[String]): Unit = {
    val actorSystem = ActorSystem("myActorSystem")
    val robot = actorSystem.actorOf(Props[RobotActor], "robotActor")
    robot ! StartChildBots
  }
}