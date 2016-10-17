package com.livvy.concurrent.CharTwo.Cineam;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class TicketOffice2 implements Runnable {
    private Cineam cineam;

    public TicketOffice2(Cineam cineam) {
        this.cineam = cineam;
    }

    @Override
    public void run() {
        cineam.sellTicket2(10);
        cineam.sellTicket2(1);
        cineam.sellTicket2(1);
        cineam.sellTicket1(3);
        cineam.returnTicket1(30);
        cineam.returnTicket2(10);
    }
}
