package com.agiledeveloper;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.util.Random;
import java.util.concurrent.Executors;

public class MyClient extends SimpleChannelHandler {
  static final String HOST = "localhost";
  static final int PORT = 8080;

  @Override
  public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    System.out.println("connected");
    Person person = new Person("Jack", "Smith", new Random().nextInt(30));

    ChannelBuffer buff = PersonEncoder.encode(person);
    Channels.write(ctx, e.getFuture(), buff);
  }

  @Override
  public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
    System.out.println("message received");

    Person person = (Person) e.getMessage();
    System.out.println(person.getFirstName() + " age " + person.getAge() + " was approved?: " + person.getApproved());
    e.getChannel().close();

    e.getFuture().addListener(ChannelFutureListener.CLOSE);
  }

  public static void main(String[] args) {
    ChannelFactory channelFactor =
        new NioClientSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool());

    ClientBootstrap clientBootstrap = new ClientBootstrap(channelFactor);

    clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
      public ChannelPipeline getPipeline() throws Exception {
        return Channels.pipeline(
            new PersonDecoder(),
            new MyClient()
        );
      }
    });

    clientBootstrap.setOption("tcpNoDelay", true);
    clientBootstrap.setOption("keepAlive", true);

    ChannelFuture future = clientBootstrap.connect(new InetSocketAddress(HOST, PORT));

    System.out.println("Client started...");

    future.awaitUninterruptibly();
    future.getChannel().getCloseFuture().awaitUninterruptibly();
    channelFactor.releaseExternalResources();
    System.out.println("Client shutting down...");
  }
}
