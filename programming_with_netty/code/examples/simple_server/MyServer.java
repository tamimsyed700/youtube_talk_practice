package com.agiledeveloper;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class MyServer extends SimpleChannelHandler {
  @Override
  public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
    ChannelBuffer buffer = (ChannelBuffer) e.getMessage();
    while(buffer.readable()) {
      System.out.print((char) buffer.readByte());
    }
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
    e.getCause().printStackTrace();

    ctx.getChannel().close();
  }

  public static void main(String[] args) {
    ChannelFactory channelFactor =
        new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool());

    ServerBootstrap serverBootstrap = new ServerBootstrap(channelFactor);

    serverBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
      public ChannelPipeline getPipeline() throws Exception {
        return Channels.pipeline(new MyServer());
      }
    });

    serverBootstrap.setOption("child.tcpNoDelay", true);
    serverBootstrap.setOption("child.keepAlive", true);

    serverBootstrap.bind(new InetSocketAddress(8080));

    System.out.println("Server started...");
  }
}
