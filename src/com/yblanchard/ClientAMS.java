package com.yblanchard;

public class ClientAMS {

    public static void main(String[] args) {
	// write your code here
        SystemManager res  = SystemManager.getInstance();
        res.createAirport("CDG");
        res.createAirline("JET");
        //res.createFlight("a","CDG","CDG",2015,11,10,"123");
    }
}
