package com.yblanchard;

import java.util.Calendar;

/**
 * Created by Yann on 01/11/2015.
 */
public class Flight {
    private Calendar flightDate;
    private String flightID;

    public Airline getAirline(){
        return Airline;
    }

    public String getID() {
        return flightID;
    }

    public Airport getOrig(){
        return  Airport;
    }

    public Airport getDest() {
        return Airport;
    }

    public Calendar getDate() {
        return flightDate;
    }

    public boolean hasSection(){
        return false;
    }

    public boolean hasSeats(){
        return false;
    }

    public boolean createSection(){
        return false;
    }

    public FlightSection findSection(){
        return FlightSection;
    }

    //public bookSeat
}
