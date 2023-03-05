package com.agiledeveloper.user;

import com.agiledeveloper.util.*;

public class FirstUser {
  public static void main(String[] args) {
    Fibonacci fibonacci = new Fibonacci();
    
    System.out.println("fib(10): " + fibonacci.fib(10));
    
    useHelper(fibonacci);
  }
  
  public Fibonacci handover() {
    return new Fibonacci();
  }
  
  public static void useHelper(Fibonacci fibonacci) {
    Helper helper = fibonacci.getHelper();
    
    System.out.println(helper);
    
    //com.agiledeveloper.impl.MyHelper myHelper = (com.agiledeveloper.impl.MyHelper) helper; // ERROR
    
    //Reflection part
    try {
      java.lang.reflect.Method method = helper.getClass().getMethod("hidden");
      System.out.println(method);
                                  
      //method.invoke(helper); //ERROR HERE.
      //To fix this, we may either place "open" on module com.agiledeveloper.util
            
    } catch(Exception ex) {
      System.out.println("ERRRO: " + ex.getMessage());
    }
  }
}