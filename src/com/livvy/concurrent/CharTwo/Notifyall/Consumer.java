package com.livvy.concurrent.CharTwo.Notifyall;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class Consumer implements Runnable {
    private EventStorage eventStorage;


    public Consumer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            eventStorage.get();
        }
    }
}
