package com.agiledeveloper.second;

import com.agiledeveloper.first.*;
import java.lang.reflect.*;

public class Second {
  public static String getInfo() {
    return "This is second";
  }
  
  public static void main(String[] args) throws Exception {
    System.out.println(Second.getInfo());
    System.out.println(First.getInfo());
  }
}