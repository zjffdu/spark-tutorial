package com.zjffdu.tutorial.jetty;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jzhang on 12/16/16.
 */
public class HelloWorldJetty {

  public static class HelloWorldHandler extends AbstractHandler {

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      response.setContentType("text/html");
      response.getWriter().println("hello world");
      response.setStatus(HttpServletResponse.SC_OK);
      baseRequest.setHandled(true);
    }
  }

  public static void main(String[] args) throws Exception {
    Server server = new Server();

    ServerConnector connector = new ServerConnector(server);
    connector.setPort(8081);
    connector.setMaxIdleTime(10000);
    server.addConnector(connector);

    ResourceHandler resourceHandler = new ResourceHandler();
    resourceHandler.setResourceBase(".");
    resourceHandler.setDirectoriesListed(true);

    HandlerList handlerList = new HandlerList();
    handlerList.setHandlers(new Handler[] {resourceHandler, new DefaultHandler()});

    server.setHandler(handlerList);

    server.start();
    server.join();
  }
}
