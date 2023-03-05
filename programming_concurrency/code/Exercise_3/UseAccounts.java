package com.agiledeveloper;

import java.util.*;
import java.util.concurrent.*;

public class UseAccounts {
  public static void main(String[] args) throws Exception {
    final Account account1 = new Account(1000);
    final Account account2 = new Account(1000);
    
    //There is a constraint that the total balance of the two accounts should be 2000 or more

    System.out.println("Account1: " + account1.getBalance());
    System.out.println("Account2: " + account2.getBalance());

    List<Callable<Boolean>> withdraws = new ArrayList<Callable<Boolean>>();
    withdraws.add(new Callable<Boolean>() {public Boolean call() {
      accountService.withdraw(account1, 200, account2);
      return true;
    }});
    withdraws.add(new Callable<Boolean>() {public Boolean call() {
      accountService.withdraw(account2, 200, account1);
      return true;
    }});

    ExecutorService executorService = Executors.newFixedThreadPool(10);
    try {
      executorService.invokeAll(withdraws);
    } catch(Exception ex) {
      System.out.println(ex.getMessaage());
    }
   

    System.out.println("Account1: " + account1.getBalance());
    System.out.println("Account2: " + account2.getBalance());
    
    executorService.shutdown();
  }
}
