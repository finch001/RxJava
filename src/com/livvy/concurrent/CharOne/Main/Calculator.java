package com.livvy.concurrent.CharOne.Main;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class Calculator implements Runnable {
    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf(
                    "%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number
            );
        }
    }
}
