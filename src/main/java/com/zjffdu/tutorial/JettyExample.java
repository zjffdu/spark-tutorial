package com.zjffdu.tutorial;


import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jzhang on 2/22/16.
 */
public class JettyExample extends AbstractHandler {



  @Override
  public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html;charset=utf-8");
    response.setStatus(HttpServletResponse.SC_OK);
    baseRequest.setHandled(true);
    response.getWriter().println("<h1>Hello World</h1>");
  }

  public static void main(String[] args) throws Exception {
    Server server = new Server(8081);
    server.setHandler(new JettyExample());
    server.start();
    server.join();
  }
}
