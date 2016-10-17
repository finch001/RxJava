package com.livvy.concurrent.CharOne.Main2;

/**
 * Created by Administrator on 2016/9/23 0023.
 */

public class PrintGenerator extends Thread {

    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }

            if (isInterrupted()) {
                System.out.printf("Number %d is Prime isInterrupted", number);
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}




