package com.agiledeveloper;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;
import org.jboss.netty.handler.codec.replay.VoidEnum;

import java.io.*;

public class PersonDecoder extends FrameDecoder {
  @Override
  protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer) throws Exception {
    Person person = null;
    if (channelBuffer.readableBytes() > 0) {
      byte[] data = new byte[channelBuffer.readableBytes()];
      channelBuffer.readBytes(data);
      person = (Person) new ObjectInputStream(new ByteArrayInputStream(data)).readObject();
    }
    return person;
  }
}
