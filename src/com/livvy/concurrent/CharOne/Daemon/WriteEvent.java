package com.livvy.concurrent.CharOne.Daemon;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class WriteEvent implements Runnable {

    private Deque<Event> deque;

    public WriteEvent(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("The thread %s has generate a event", Thread.currentThread().getId()));
            deque.addFirst(event);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
