package com.agiledeveloper.stuff;

import com.agiledeveloper.first.Helper;

public class MyHelper implements Helper {
  public void doWork() {
    System.out.println("MyHelper.doWork called...");
  }                                   
  
  public void secret() {
    System.out.println("shhhhh...");
  }
}