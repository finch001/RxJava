package com.livvy.clone;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
public class CloneDemo {
    public static void main(String[] args) {
        testPrototype();
    }

    private static void testPrototype() {
        Address address = new Address();

        address.setAddress("oridial address");
        Student newPro = new Student();
        newPro.setName("original object");
        newPro.setAddress(address);
        newPro.setAge(24);

        Student copyObj = null;
        try {
            copyObj = (Student) newPro.deepClone();
            copyObj.setName("testCopy");
            copyObj.setAge(26);
            copyObj.getAddress().setAddress("change object");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("original object:" + newPro.getName());
    }

}
