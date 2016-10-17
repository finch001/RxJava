package com.livvy.concurrent.CharOne.ThreadLocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public class SafeTask implements Runnable {

    private static ThreadLocal<Date> localDate = new ThreadLocal<Date>() {
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Current Thread id: %s  : time %s \n", Thread.currentThread().getId(), localDate.get());

        try {
            TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Stop Thread id: %s  : time %s \n", Thread.currentThread().getId(), localDate.get());

    }
}
