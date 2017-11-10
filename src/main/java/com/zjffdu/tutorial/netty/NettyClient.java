package com.zjffdu.tutorial.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by jzhang on 6/28/17.
 */
public class NettyClient {

  public static void main(String[] args) {
    NioEventLoopGroup workerGroup = new NioEventLoopGroup();
    Bootstrap b = new Bootstrap();
    b.group(workerGroup);
    b.channel(NioSocketChannel.class);

    b.handler(new ChannelInitializer<SocketChannel>() {
      @Override
      public void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new TimeStampEncoder(),new TimeStampDecoder(),new ClientHandler());
      }
    });

    String serverIp = "192.168.203.156";
    b.connect(serverIp, 19000);
  }
}
