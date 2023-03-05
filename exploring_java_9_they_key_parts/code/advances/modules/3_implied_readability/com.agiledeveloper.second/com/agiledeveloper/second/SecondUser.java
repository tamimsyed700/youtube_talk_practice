package com.agiledeveloper.user.another;

import com.agiledeveloper.user.FirstUser;

public class SecondUser {
  public static void main(String[] args) {
    FirstUser firstUser = new FirstUser();
    
    System.out.println(firstUser);
    
    //The following will not work as is.
    //option 1. In the module-info.java for this project, add requires com.agiledeveloper;
    //Option 2. Change in module-info.java for the com.agiledeveloper.first from
    //requires com.agiledeveloper;
    //to
    //requires transitive com.agiledeveloper;
    
    
    com.agiledeveloper.util.Fibonacci fibonacci = firstUser.handover();
    System.out.println(fibonacci.fib(5));
  }
}
