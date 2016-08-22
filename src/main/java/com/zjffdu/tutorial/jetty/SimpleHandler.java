package com.zjffdu.tutorial.jetty;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jzhang on 7/29/16.
 */
public class SimpleHandler extends AbstractHandler {
  @Override
  public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setStatus(HttpServletResponse.SC_OK);
    response.setContentType("text/plain;charset=utf-8");
    response.getWriter().println("hello world");
  }

  public static void main(String[] args) throws Exception {
    Server server = new Server();
    server.setHandler(new SimpleHandler());
    server.start();
    server.join();
  }
}
