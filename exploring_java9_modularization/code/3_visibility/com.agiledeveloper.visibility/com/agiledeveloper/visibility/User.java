package com.agiledeveloper.visibility;

import com.agiledeveloper.math.*;

public class User {
  public static void main(String[] args) throws Exception {
    Fibonacci fibonacci = new Fibonacci();
    
    System.out.println("fib(12): " + fibonacci.fib(12));
    
    System.out.println(fibonacci.getHelper());
    
    Helper helper = fibonacci.getHelper();
    System.out.println(helper);
    
    //com.agiledeveloper.math.stuff.MyHelper helper2 = (com.agiledeveloper.math.stuff.MyHelper) helper; //ERROR at compile time

    //You may try to make this package visible first in 1_creating_module, then successfully compile this code, then
    //remove the visibility and recompile 1_creating_module, then without recompiling try running this code to see the runtime error.
  }
  
  public static Fibonacci handOver() {
    return new Fibonacci();
  }
}
