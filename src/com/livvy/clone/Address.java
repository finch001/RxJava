package com.livvy.clone;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
public class Address implements Cloneable, Serializable {
    private String address;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
