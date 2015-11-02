package com.yblanchard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Yann on 01/11/2015.
 */
public class Flight {


    private Calendar flightDate;
    private String flightID;
    private List<FlightSection> sections = new ArrayList<FlightSection>();
    private Airline airline;
    private Airport destination;
    private Airport origin;


    public Flight(String flightID, Calendar flightDate) {
        this.flightID = flightID;
        this.flightDate = flightDate;
    }

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
