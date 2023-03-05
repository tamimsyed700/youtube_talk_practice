package com.agiledeveloper.first;

import com.agiledeveloper.stuff.MyHelper;

public class First {
  public static String getInfo() {
    return "this is first";
  }
  
  public static Helper getHelper() {
    return new MyHelper();
  }
}