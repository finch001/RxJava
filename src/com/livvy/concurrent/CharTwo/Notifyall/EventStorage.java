package com.livvy.concurrent.CharTwo.Notifyall;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class EventStorage {
    private int maxSize;
    private List<Date> storage;

    public EventStorage() {
        this.maxSize = 20;
        this.storage = new LinkedList<>();
    }

    // 这两者是同一把锁
    public synchronized void set() {
        while (storage.size() == maxSize) {
            try {
                // 才会释放锁
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        storage.add(new Date());
        System.out.printf("Set: %d  \n", storage.size());
        notifyAll();
    }

    // 这两者是同一把锁
    public synchronized void get() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Set: %d  %s \n", storage.size(), ((LinkedList<?>) storage).poll());
        notifyAll();
    }
}
