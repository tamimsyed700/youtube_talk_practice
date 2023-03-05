package com.agiledeveloper;

public class AccountService {
  public void transfer(final Account from, final Account to, final int amount) {
    from.withdraw(amount);
    to.deposit(amount);
  }

  public void withdraw(final Account from, final int amount, final Account constraingAccount) {
    if (from.getBalance() + constrainingAccount.getBalance() - amount >= 2000) {
      from.withdraw(amount);
    }
  }
}
