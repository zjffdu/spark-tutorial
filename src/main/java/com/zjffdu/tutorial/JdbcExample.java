package com.zjffdu.tutorial;

import java.sql.*;

/**
 * Created by jzhang on 7/21/16.
 */
public class JdbcExample {

  public static void main(String[] args) throws SQLException {
    Connection conn = DriverManager.getConnection("jdbc:hive2://localhost:10015");
    Statement stmt = conn.createStatement();
    ResultSet rs  = stmt.executeQuery("select * from cities where id > 1");
    while(rs.next()) {
      System.out.println(rs.getObject(1));
    }


  }
}
