package com.livvy.clone;

import java.io.*;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
public class Student implements Cloneable, Serializable {
    private String name;
    private int age;

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    protected Object clone() {
        Student student = null;
        try {
            student = (Student) super.clone();
            student.address = (Address) this.address.clone();
            return student;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);
        //从流里读出来
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (oi.readObject());
    }

}
