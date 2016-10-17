package com.livvy.concurrent.CharOne.Daemon;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class Event {
    private Date date;

    private String event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
