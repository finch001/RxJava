package com.livvy.concurrent.CharOne.ThreadLocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public class UnSafeTask implements Runnable {
    // 所有已
    private Date startDate;

    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Current Thread id: %s  : time %s \n", Thread.currentThread().getId(), startDate);

        try {
            TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("stop Thread id: %s  : time %s \n", Thread.currentThread().getId(), startDate);
    }
}
