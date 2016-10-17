package com.livvy.concurrent.CharOne.ThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public class CoreThread {
    public static void main(String[] args) {
        SafeTask task = new SafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
