package com.agiledeveloper.second;

import com.agiledeveloper.first.*;
import java.lang.reflect.*;

public class Second {
  public static void main(String[] args) throws Exception {
    System.out.println("This is second");
    System.out.println(First.getInfo());
    
    Helper helper = First.getHelper();
    
    System.out.println(helper);
    
    helper.doWork();
    
    //com.agiledeveloper.stuff.MyHelper h = null; //ERROR
    
    Method method = helper.getClass().getMethod("secret");
    
    System.out.println(method);
    
    method.invoke(helper);
  }
}