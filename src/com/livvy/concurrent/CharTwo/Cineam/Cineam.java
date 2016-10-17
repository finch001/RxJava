package com.livvy.concurrent.CharTwo.Cineam;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class Cineam {
    private long ticket1;
    private long ticket2;

    private Object lock1;
    private Object lock2;

    public Cineam() {
        lock1 = new Object();
        lock2 = new Object();
        ticket1 = 20;
        ticket2 = 20;
    }

    public boolean sellTicket1(int number) {
        synchronized (lock1) {
            if (number < ticket1) {
                ticket1 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean sellTicket2(int number) {
        synchronized (lock2) {
            if (number < ticket2) {
                ticket2 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean returnTicket1(int number) {
        synchronized (lock1) {
            ticket1 += number;
            return true;
        }
    }

    public boolean returnTicket2(int number) {
        synchronized (lock2) {
            ticket2 += number;
            return true;
        }
    }

    public long getTicket1() {
        return ticket1;
    }

    public long getTicket2() {
        return ticket2;
    }


}
