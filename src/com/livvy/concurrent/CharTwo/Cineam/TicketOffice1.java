package com.livvy.concurrent.CharTwo.Cineam;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class TicketOffice1 implements Runnable {
    private Cineam cineam;

    public TicketOffice1(Cineam cineam) {
        this.cineam = cineam;
    }

    @Override
    public void run() {
        cineam.sellTicket1(3);
        cineam.sellTicket1(2);
        cineam.sellTicket2(2);
        cineam.returnTicket1(3);

        cineam.sellTicket2(2);
        cineam.sellTicket2(3);
        cineam.sellTicket2(1);
        cineam.sellTicket2(5);

    }
}
