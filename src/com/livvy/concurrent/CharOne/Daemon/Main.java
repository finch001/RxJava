package com.livvy.concurrent.CharOne.Daemon;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class Main {
    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<>();
        WriteEvent writeevent = new WriteEvent(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writeevent);
            thread.start();
        }

        CleanEvent cleanEvent = new CleanEvent(deque);
        cleanEvent.start();
    }

}
