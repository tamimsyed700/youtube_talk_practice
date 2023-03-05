package com.agiledeveloper;

public class Account implements Comparable<Account> {
  private int balance;
  
  public Account(int initialBalance) { balance = initialBalance; }
  
  public synchronized void deposit(int amount) {
    if (amount < 0) throw new RuntimeException("Invalid amount");
    balance += amount;
  }

  public synchronized void withdraw(int amount) {
    if (amount < 0) throw new RuntimeException("Invalid amount");
    if (amount > balance) throw new RuntimeException("Insufficient fund");
    balance -= amount;
  }
  
  public synchronized int getBalance() { return balance; }

    public int compareTo(Account account) {
        return new Integer(hashCode()).compareTo(account.hashCode());
    }
}