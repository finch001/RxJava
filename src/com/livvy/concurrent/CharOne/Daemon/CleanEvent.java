package com.livvy.concurrent.CharOne.Daemon;

import java.util.Date;
import java.util.Deque;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class CleanEvent extends Thread {
    private Deque<Event> deque;

    public CleanEvent(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            cleanDate(date);
        }
    }

    private void cleanDate(Date date) {
        long diff;
        boolean delete;

        if (deque.size() == 0) {
            return;
        }

        delete = false;

        do {
            Event e = deque.getLast();
            diff = date.getTime() - e.getDate().getTime();
            if (diff > 10000) {
                System.out.printf("cleaner : %s \n", e.getEvent());
                deque.removeLast();
                delete = true;
            }

        } while (diff > 10000);
        if (delete) {
            System.out.printf("clenar : Size the of queue : %d\n", deque.size());
        }
    }
}
