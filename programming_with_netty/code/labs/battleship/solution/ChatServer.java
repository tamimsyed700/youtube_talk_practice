package com.agiledeveloper;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class ChatServer extends SimpleChannelHandler {
  private final static ChannelGroup channelGroup = new DefaultChannelGroup("chat-group");

  @Override
  public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    channelGroup.add(ctx.getChannel());
    super.channelConnected(ctx, e);
  }

  @Override
  public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
    ChannelBuffer messageBuffer = (ChannelBuffer) e.getMessage();

    for(Channel aChannel : channelGroup) {
      if (!aChannel.equals(ctx.getChannel())) {
        aChannel.write(messageBuffer);
      }
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
        return Channels.pipeline(new ChatServer());
      }
    });

    serverBootstrap.setOption("child.tcpNoDelay", true);
    serverBootstrap.setOption("child.keepAlive", true);

    serverBootstrap.bind(new InetSocketAddress(8080));

    System.out.println("Server started...");
  }
}
