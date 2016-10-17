package com.livvy.concurrent.CharTwo.Notifyall;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class Producer implements Runnable {
    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }
}
