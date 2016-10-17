package com.livvy.concurrent.CharTwo.Account;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class Bank implements Runnable {
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.subAccount(1000);
        }
    }
}
