package com.livvy.concurrent.CharOne.Main;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Calculator cal = new Calculator(i);
            Thread thread = new Thread(cal);
            thread.start();
        }
    }
}
