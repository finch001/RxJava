package com.livvy.concurrent.CharTwo.Notifyall;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class NotifyAll {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();

        Consumer consumer = new Consumer(storage);
        Producer producer = new Producer(storage);

        Thread consumerThread = new Thread(consumer);
        Thread producerThread = new Thread(producer);

        consumerThread.start();
        producerThread.start();

    }

}
