package com.livvy.concurrent.CharOne.Main2;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class Main2 {
    public static void main(String[] args) {
        Thread task = new PrintGenerator();
        task.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }

}
