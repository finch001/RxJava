package com.livvy.Junit.Charpter2.DefaultController;

import com.livvy.Junit.Charpter2.Interface.Request;
import com.livvy.Junit.Charpter2.Interface.Response;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class ErrorResponse implements Response {
    private Request originalRequest;
    private Exception originalException;

    public ErrorResponse(Request originalRequest, Exception originalException) {
        this.originalRequest = originalRequest;
        this.originalException = originalException;
    }

    public Request getOriginalRequest() {
        return originalRequest;
    }

    public Exception getOriginalException() {
        return originalException;
    }

    @Override
    public String getName() {
        return null;
    }
}
