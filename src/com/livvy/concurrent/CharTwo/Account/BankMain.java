package com.livvy.concurrent.CharTwo.Account;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class BankMain {
    public static void main(String[] agrs) {
        Account account = new Account();
        account.setBalance(100000);

        Bank bank = new Bank(account);
        Company company = new Company(account);

        Thread comsue = new Thread(bank);
        Thread addComsue = new Thread(company);

        comsue.start();
        addComsue.start();

        try {
            comsue.join();
            addComsue.join();

            System.out.printf("Account %f final account number", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
