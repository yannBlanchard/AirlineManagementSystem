package com.yblanchard;

public class ClientAMS {

    public static void main(String[] args) {
	// write your code here
        SystemManager res  = SystemManager.getInstance();
        res.createAirport("CDG");
        res.createAirport("DEN");
        res.createAirline("JET");
        res.createFlight("JET", "CDG","DEN",2015,11,10,"123");
        res.createSection("JET","123",5,6,SeatClass.BUSI);
    }
}
