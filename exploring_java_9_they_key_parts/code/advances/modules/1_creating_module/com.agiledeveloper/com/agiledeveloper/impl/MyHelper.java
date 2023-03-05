package com.agiledeveloper.impl;

import com.agiledeveloper.util.Helper;

public class MyHelper implements Helper {
  public int add(int op1, int op2) {
    return op1 + op2;
  }
  
  public void hidden() {
    System.out.println("hidden method called...");
  }
}
