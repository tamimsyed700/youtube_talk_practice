package com.agiledeveloper.util;
import com.agiledeveloper.impl.MyHelper;

public class Fibonacci {
  public int fib(int number) {
    if(number < 2)
      return 1;
    return fib(number - 1) + fib(number - 2);
  }
  
  public Helper getHelper() {
    return new MyHelper();
  }
}
