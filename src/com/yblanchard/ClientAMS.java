package com.yblanchard;

public class ClientAMS {

    public static void main(String[] args) {
	// write your code here
        SystemManager res  = SystemManager.getInstance();
        //Create airport
        res.createAirport("CDG");
        res.createAirport("DEN");
        res.createAirport("LON");
        res.createAirport("AZ");
        res.createAirport("AZER");

        //create airline
        res.createAirline("JET");
        res.createAirline("EASY");
        res.createAirline("AIRFR");
        //create flight
        res.createFlight("JET", "CDG","DEN",2015,11,10,"123");
        res.createFlight("AIRFR", "CDG","DEN",2015,11,10,"234");
        res.createFlight("EASY", "LON","DEN",2015,11,10,"147");
        res.createFlight("JET", "CDG","DEN",2015,11,10,"486");
        //create section
        res.createSection("JET","123",5,5,SeatClass.ECO);
        res.createSection("JET","123",6,2,SeatClass.BUSI);
        res.createSection("AIRFR","234",6,2,SeatClass.BUSI);
        res.createSection("EASY","147",2,3,SeatClass.FIRST);
        //find avaailable flight
        //res.findAvailableFlights("CDG","DEN");
        //book seat
        res.bookSeat("AIRFR","234",SeatClass.BUSI,2,'B'); // plante
        //display system
       // res.displaySystemDetails();*/


    }
}
