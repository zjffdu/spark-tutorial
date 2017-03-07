package com.zjffdu.tutorial.livy

import com.mashape.unirest.http.Unirest
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.JsonNode

/**
  * Created by jzhang on 9/29/16.
  */
object LivyExample {

  def main(args: Array[String]): Unit = {
    // create session

    val response = Unirest.post("http://localhost:8998/sessions")
      .header("Content-Type", "application/json")
      .body("""{"kind": "spark"}, {"conf": {"spark.eventLog.enabled": "true"}}""")
      .asJson()
    println(response.getBody)
    println(response.getStatusText)

    var state = "starting"
    while (state == "starting") {
      val sessionStatusResponse = Unirest.get("http://localhost:8998/sessions/0").asJson()
      state = sessionStatusResponse.getBody.getObject.getString("state")
      Thread.sleep(1000 * 3)
      println("session state:" + state)
    }

    // execute statements
    (1 to 2000).foreach { i =>
      val stmtResponse = Unirest.post("http://localhost:8998/sessions/0/statements")
        .header("Content-Type", "application/json")
        .body(""" {"code": "println(sc.textFile(\"bank-full.csv\").collect().mkString(\",\"))"} """)
        .asJson()

      println(stmtResponse.getBody)
      println(stmtResponse.getStatusText)

      val stmtId = stmtResponse.getBody.getObject.getString("id")
      var stmtState = "running"
      while(stmtState == "running") {
        val stmtStatusResponse = Unirest.get("http://localhost:8998/sessions/0/statements/" + stmtId).asJson()
        stmtState = stmtStatusResponse.getBody.getObject.getString("state");
        Thread.sleep(1000)
        println("statement state:" + stmtState)
      }
    }
  }

}
