package com.livvy.concurrent.CharTwo.Account;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void addAccount(double num) {
        double temp = balance;

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        temp += num;
        balance = temp;
    }

    public synchronized void subAccount(double num) {
        double temp = balance;

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        temp -= num;
        balance = temp;
    }

}
