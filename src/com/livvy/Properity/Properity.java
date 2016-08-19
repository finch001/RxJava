package com.livvy.Properity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class Properity {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("C:/Users/Administrator/Desktop/config.info"));

            Properties p = new Properties();

            p.load(fis);

            String server_api_pre_http = p.getProperty("server_api_pre_http");
            String server_api_pre_https = p.getProperty("server_api_pre_https");
            String server_api_share_http = p.getProperty("server_api_share_http");

            System.out.println("server_api_pre_http " + server_api_pre_http);
            System.out.println("server_api_pre_https " + server_api_pre_https);
            System.out.println("server_api_share_http " + server_api_share_http);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
