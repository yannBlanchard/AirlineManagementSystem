package com.yblanchard;

import java.util.*;

/**
 * Created by Yann on 01/11/2015.
 */
public class Flight {

    private Calendar flightDate;
    private String flightID;
    //private List<FlightSection> sections = new ArrayList<FlightSection>();
    private Map<SeatClass, FlightSection> sections = new HashMap<>();
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


    public boolean createSection(int rows,int cols,SeatClass s){
        //Création de la section

        sections.put(s,new FlightSection(s,rows,cols));
        return true;

    }

    public FlightSection findSection(SeatClass s){
        return sections.get(s);
    }

    public void bookSeat(SeatClass s, int row,char col){
        sections.get(s).bookSeat(new SeatID(row,col));
    }

    public Airport getDestination() {
        return destination;
    }

    public Airport getOrigin() {
        return origin;
    }
}
