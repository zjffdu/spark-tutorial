package com.zjffdu.tutorial;


import com.fasterxml.jackson.databind.JsonNode;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;

/**
 * Created by jzhang on 2/16/16.
 */
public class UniRestExample {

  private static Log LOGGER = LogFactory.getLog(UniRestExample.class);

  public static void execute(String statement) throws UnirestException, JSONException {
    LOGGER.info("Executing statement:" + statement);
    HttpResponse<com.mashape.unirest.http.JsonNode> response = Unirest.post("http://localhost:8998/sessions/0/statements")
            .header("Content-Type", "application/json")
            .body("{\"code\":\"" + statement.replace("\n", "\\n") + "\"}")
            .asJson();
    LOGGER.info(response.getBody().toString());
    int statementId = response.getBody().getObject().getInt("id");
    String statementURL = "http://localhost:8998/sessions/0/statements/" + statementId;
    HttpResponse<com.mashape.unirest.http.JsonNode> statementResp = Unirest.get(statementURL).asJson();
    LOGGER.info("Final Result:" + statementResp.getBody().getObject()
            .getJSONObject("output").getJSONObject("data").getString("text/plain"));
  }

  public static void main(String[] args) throws UnirestException, JSONException {
    execute("print(1+1)\n"
            + "print(1+1)");
//    execute("a=10");
//    execute("a+1");
//    HttpResponse<com.mashape.unirest.http.JsonNode> response = Unirest.post("http://localhost:8998/sessions")
//            .header("Content-Type", "application/json")
//            .body("{\"kind\":\"" + "pyspark" + "\"}")
//            .asJson();
//    LOGGER.info(response.getBody().toString());
//    HttpResponse<com.mashape.unirest.http.JsonNode> response = Unirest.delete("http://localhost:8998/sessions/1")
//            .asJson();
//    LOGGER.info(response.getBody().toString());
  }
}
