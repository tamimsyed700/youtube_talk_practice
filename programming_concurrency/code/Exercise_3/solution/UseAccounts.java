package com.agiledeveloper;

import java.util.*;
import java.util.concurrent.*;

public class UseAccounts {
  public static void main(String[] args) throws Exception {
    final Account account1 = new Account(1100);
    final Account account2 = new Account(1100);
    
    System.out.println("Account1: " + account1.getBalance());
    System.out.println("Account2: " + account2.getBalance());
    final AccountService accountService = new AccountService();

    //There is a constraint, the balance of two accounts
    //have to be 2000 or more.
    List<Callable<Boolean>> transfers = new ArrayList<Callable<Boolean>>();
    transfers.add(new Callable<Boolean>() {public Boolean call() {
      accountService.withdraw(account1, 100, account2);
      return true;
    }});
    transfers.add(new Callable<Boolean>() {public Boolean call() {
        accountService.withdraw(account2, 200, account1);
      return true;
    }});

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    executorService.invokeAll(transfers);
    System.out.println("Account1: " + account1.getBalance());
    System.out.println("Account2: " + account2.getBalance());
    executorService.shutdown();
  }
}
