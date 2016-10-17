package com.livvy.concurrent.CharTwo.Cineam;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class Office {
    public static void main(String[] args) {
        Cineam cineam = new Cineam();

        TicketOffice1 ticketOffice1 = new TicketOffice1(cineam);
        TicketOffice2 ticketOffice2 = new TicketOffice2(cineam);

        Thread office1 = new Thread(ticketOffice1);
        Thread office2 = new Thread(ticketOffice2);

        office1.start();
        office2.start();

        try {
            office1.join();
            office2.join();

            System.out.printf("Room1 number :  %d\n", cineam.getTicket1());
            System.out.printf("Room2 number :  %d\n", cineam.getTicket2());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
