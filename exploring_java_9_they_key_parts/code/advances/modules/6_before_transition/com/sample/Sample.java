package com.sample;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.*;

public class Sample {
  @Test
  public void canary() {
    assertTrue(true);
  }                  
  
  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("com.sample.Sample");    
  }
}