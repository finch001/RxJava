package com.livvy.concurrent.CharOne.Join;

import com.livvy.concurrent.CharOne.DataSourceLoader;
import com.livvy.concurrent.CharOne.NetSourceLoader;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new DataSourceLoader());
        Thread thread2 = new Thread(new NetSourceLoader());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main :Config complete %s", new Date());
    }
}
