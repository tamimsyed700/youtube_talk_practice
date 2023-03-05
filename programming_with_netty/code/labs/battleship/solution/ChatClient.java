package com.agiledeveloper;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class ChatClient extends SimpleChannelHandler {
  static final String HOST = "localhost";
  static final int PORT = 8080;

  @Override
  public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    System.out.println("connected");

    readAndSendText(e.getChannel());
  }

  void readAndSendText(Channel channel) {
    String input = System.console().readLine();
    if (input != null) {
      ChannelBuffer buff = ChannelBuffers.buffer(input.length());
      buff.writeBytes(input.getBytes());
      channel.write(buff);
    } else {
      channel.close();
    }
  }

  @Override
  public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
    ChannelBuffer buff = (ChannelBuffer) e.getMessage();

    byte[] data = new byte[buff.readableBytes()];
    buff.readBytes(data);

    System.out.println(new String(data));
    readAndSendText(e.getChannel());
  }

  public static void main(String[] args) {
    ChannelFactory channelFactor =
        new NioClientSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool());

    ClientBootstrap clientBootstrap = new ClientBootstrap(channelFactor);

    clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
      public ChannelPipeline getPipeline() throws Exception {
        return Channels.pipeline(new ChatClient());
      }
    });

    clientBootstrap.setOption("tcpNoDelay", true);
    clientBootstrap.setOption("keepAlive", true);

    ChannelFuture future = clientBootstrap.connect(new InetSocketAddress(HOST, PORT));

    System.out.println("Client started... press Ctrl+d to shutdown");

    future.awaitUninterruptibly();
    future.getChannel().getCloseFuture().awaitUninterruptibly();
    channelFactor.releaseExternalResources();
    System.out.println("Client shutting down...");
  }
}
