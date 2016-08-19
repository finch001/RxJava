package com.livvy.Junit.Charpter2.Interface;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public interface Controller {
    Response processRequest (Request request);

    void addHandler(Request request, RequestHandler requestHandler);
}
