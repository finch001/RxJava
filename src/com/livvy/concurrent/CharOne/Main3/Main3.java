package com.livvy.concurrent.CharOne.Main3;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class Main3 {
    public static void main(String[] args) {
        FileSearch search = new FileSearch("D:\\AS_workspace", "WebViewDemo.iml");
        Thread thread = new Thread(search);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
