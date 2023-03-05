package com.agiledeveloper.second;
import com.agiledeveloper.visibility.*;

public class SecondUser {
  public static void main(String[] args) {
    User user = new User();
    
    System.out.println(user);
    
    com.agiledeveloper.math.Fibonacci fibonacci = user.handOver();
    System.out.println(fibonacci);
    //To fix this, we have two options:
    //1. edit 4_implied_readability/com.agiledeveloper.second/module-info.java
    //to add requires com.agiledeveloper;
    //This option is not much fun.
    
    //2. edit 3_visibility/com.agiledeveloper.visibility/module-info.java
    //to change 
    //requires com.agiledeveloper;
    //to
    //requires transitive com.agiledeveloper;
  }
}
