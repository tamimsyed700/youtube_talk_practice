package com.agiledeveloper;

import akka.stm.Atomic;

public class AccountService {
  public void transfer(final Account from, final Account to, final int amount) {
    new Atomic<Object>() {
        @Override
        public Object atomically() {
            to.deposit(amount);
            from.withdraw(amount);
            return null;
        }
    }.execute();
  }
}
