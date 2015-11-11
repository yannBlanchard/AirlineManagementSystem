package com.yblanchard;

public class ClientAMS {

    public static void main(String[] args) {
	// write your code here
        SystemManager res  = SystemManager.getInstance();
        res.createAirport("CDG");
        res.createAirport("DEN");
        res.createAirline("JET");
        res.createAirline("EASY");
        res.createAirline("AIRFR");
        res.createFlight("JET", "CDG","DEN",2015,11,10,"123");
        res.createFlight("AIRFR", "CDG","DEN",2015,11,10,"234");
        res.createFlight("JET", "CDG","DEN",2015,11,10,"486");
        res.createSection("JET","123",5,5,SeatClass.ECO);
        res.createSection("JET","123",6,2,SeatClass.BUSI);
        res.createSection("AIRFR","234",6,2,SeatClass.BUSI);
        res.findAvailableFlights("CDG","DEN");

        res.bookSeat("AIRFR","234",SeatClass.BUSI,2,'B');
        /*res.createSection("JET","123",5,6,SeatClass.BUSI);

        res.bookSeat("JET","123",SeatClass.BUSI,5,'B');*/
    }
}
