package com.agiledeveloper;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class MyServer extends SimpleChannelHandler {
  static final ChannelGroup channelGroup = new DefaultChannelGroup("MyServer Channels");

  @Override
  public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
    Person person = (Person) e.getMessage();

    System.out.println(person.getFirstName());
    System.out.println(person.getLastName());
    System.out.println(person.getAge());

    person.setApproved(person.getAge() > 18);

    e.getChannel().write(PersonEncoder.encode(person));
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
    e.getCause().printStackTrace();

    ctx.getChannel().close();
  }

  @Override
  public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    System.out.println("Disconnected from client");
    super.channelDisconnected(ctx, e);
  }

  public static void main(String[] args) {
    ChannelFactory channelFactor =
        new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool());

    ServerBootstrap serverBootstrap = new ServerBootstrap(channelFactor);

    serverBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
      public ChannelPipeline getPipeline() throws Exception {
        return Channels.pipeline(
            new PersonDecoder(),
            new MyServer()
        );
      }
    });

    serverBootstrap.setOption("child.tcpNoDelay", true);
    serverBootstrap.setOption("child.keepAlive", true);

    Channel channel = serverBootstrap.bind(new InetSocketAddress(8080));

    channelGroup.add(channel);

    System.out.println("Server started...");
    
    System.out.println("Enter to terminate the server");
    
    System.console().readLine();
    
    System.out.println("Terminating the server");

    channelGroup.close().awaitUninterruptibly();

    channelFactor.releaseExternalResources();
  }
}
