package com.agiledeveloper;

import akka.stm.Atomic;
import akka.stm.TransactionFactory;
import akka.stm.TransactionFactoryBuilder;

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

    public void withdraw(final Account from, final int amount,
                         final Account constrainingAccount) {

        TransactionFactory factory =
          new TransactionFactoryBuilder()
              .setWriteSkew(false)
              .setTrackReads(true)
              .build();

        new Atomic<Object>(factory) {
            @Override
            public Object atomically() {
                if(from.getBalance() + constrainingAccount.getBalance() -
                        amount < 2000) {
                    System.out.println("nope, balance will go low...");
                    throw new RuntimeException("Balance will go low...");
                }
                from.withdraw(amount);
                return null;
            }
        }.execute();

    }
}
