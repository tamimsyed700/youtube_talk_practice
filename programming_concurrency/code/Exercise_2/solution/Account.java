package com.agiledeveloper;

import akka.stm.Atomic;
import akka.stm.Ref;

public class Account {
  private Ref<Integer> balance;
  
  public Account(int initialBalance) {
      balance = new Ref<Integer>(initialBalance);
  }
  
  public void deposit(final int amount) {
    if (amount < 0) throw new RuntimeException("Invalid amount");
    new Atomic<Object>() {
        @Override
        public Object atomically() {
            balance.swap(getBalance() + amount);
            System.out.println("Deposited " + amount + " will it stay???");
            return null;
        }
    }.execute();
  }

  public void withdraw(final int amount) {
    if (amount < 0) throw new RuntimeException("Invalid amount");
    new Atomic<Object>() {
        @Override
        public Object atomically() {
            if (amount > getBalance()) throw new RuntimeException("Insufficient fund");
            balance.swap(getBalance() - amount);
            return null;
        }
    }.execute();
  }
  
  public int getBalance() { return balance.get(); }
}