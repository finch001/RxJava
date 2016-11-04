package com.livvy.concurrent.CharOne;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class DataSourceLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("beginning data source loading : %s \n", new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("DataSourceLoader config end time : %s\n", new Date());


    }
}
