package com.zjffdu.tutorial.scala

import java.io.File
import javax.servlet.http.{HttpServlet, HttpServletResponse, HttpServletRequest}

import org.eclipse.jetty.server.nio.SelectChannelConnector
import org.eclipse.jetty.server.{Request, Server}
import org.eclipse.jetty.server.handler._
import org.eclipse.jetty.servlet.{ServletHolder, ServletContextHandler}
import org.scalatra.ScalatraServlet

/**
 * Created by jzhang on 3/8/16.
 */

class HelloHandler extends AbstractHandler {
  override def handle(target: String,
                      baseRequest: Request,
                      request: HttpServletRequest,
                      response: HttpServletResponse): Unit = {
    response.setContentType("text/html;charset=utf-8")
    response.setStatus(HttpServletResponse.SC_OK)
    baseRequest.setHandled(true)
    response.getWriter.println("<h1>hello world</h1>")
  }
}

class HelloServlet extends HttpServlet{

  override def doGet(req : HttpServletRequest, resp:HttpServletResponse) {
    resp.setContentType("text/html")
    resp.getWriter.println("<ht1>hello</h1>")
  }
}

class HelloScalatraServlet extends ScalatraServlet {

}

object JettyExample {

  def main(args: Array[String]): Unit = {
    println(new File(".").getAbsolutePath)
    val server = new Server()
    server.setHandler(new HelloHandler)

    val connector = new SelectChannelConnector()
    connector.setPort(18888)
    connector.setMaxIdleTime(10000)

    server.setConnectors(Array(connector))

    val resourceHandler = new ResourceHandler()
    resourceHandler.setDirectoriesListed(true)
    resourceHandler.setResourceBase(".")

    val handlerList = new HandlerList()
    handlerList.setHandlers(Array(resourceHandler, new DefaultHandler))

    server.setHandler(handlerList)
    server.start()
    server.join()
  }
}
