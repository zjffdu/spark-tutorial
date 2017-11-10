package com.zjffdu.tutorial.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by jzhang on 6/28/17.
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    LoopBackTimeStamp ts = (LoopBackTimeStamp) msg;
    ctx.writeAndFlush(ts); //recieved message sent back directly
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    // Close the connection when an exception is raised.
    cause.printStackTrace();
    ctx.close();
  }
}
