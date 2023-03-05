package com.agiledeveloper;

import java.util.Arrays;

public class AccountService {
  public void transfer(final Account from, final Account to, final int amount) {
      Account[] accounts = new Account[] { from, to };

      Arrays.sort(accounts);
      synchronized (accounts[0]) {
          synchronized (accounts[1]) {
              from.withdraw(amount);
              to.deposit(amount);
          }
      }
  }
}
