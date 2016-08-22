package com.zjffdu.tutorial.spark

import java.sql.DriverManager
import java.util.Properties

/**
 * Created by jzhang on 3/10/16.
 */
object HiveThriftServerExample {

  def main(args: Array[String]): Unit = {
    Class.forName("org.apache.hive.jdbc.HiveDriver");
    val url = "jdbc:hive2://localhost:10015/default";
    val info = new Properties();
    val conn = DriverManager.getConnection(url, info);
    val tables = conn.getMetaData().getTables(conn.getCatalog(),
      null, null, null);
    val resultSet = conn.getMetaData.getSchemas
    while(resultSet.next()) {
      println(resultSet.getString(1) + ":" +resultSet.getString(2))
    }

    val statement = conn.createStatement()
    val result = statement.executeQuery("select count(1) from test.test_1")
    while(result.next()) {
      println(result.getString(1))
    }
  }
}
