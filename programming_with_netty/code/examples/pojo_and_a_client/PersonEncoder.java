package com.agiledeveloper;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class PersonEncoder {
  public static ChannelBuffer encode(Person person) throws Exception {
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    new ObjectOutputStream(stream).writeObject(person);
    ChannelBuffer buff = ChannelBuffers.buffer(stream.size());
    buff.writeBytes(stream.toByteArray());
    return buff;
  }
}
