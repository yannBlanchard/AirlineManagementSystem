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

    public Flight(Calendar flightDate, String flightID, Airport destination, Airport origin) {
        this.flightDate = flightDate;
        this.flightID = flightID;
        this.destination = destination;
        this.origin = origin;
    }

    public Airport getOrigin() {
        return origin;
    }

    public Calendar getFlightDate() {
        return flightDate;
    }

    public String getFlightID() {
        return flightID;
    }

    public List<FlightSection> getSections() {
        return sections;
    }

    public Airline getAirline() {
        return airline;
    }

    public Airport getDestination() {
        return destination;
    }

    public void createSection(int rows,int cols,SeatClass s){
        //Création de la section
        new FlightSection(s,rows,cols);


    }

    /*public FlightSection findSection(){
        return FlightSection;
    }*/

    //public bookSeat
}
