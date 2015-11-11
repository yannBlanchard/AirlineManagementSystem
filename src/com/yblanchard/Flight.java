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
        Boolean success = false;
        //Création de la section
        if(sections.get(s) == null) {
            sections.put(s, new FlightSection(s, rows, cols));
            success = true;
        }else{
            System.err.println("La section existe déjà.");
            success = false;
        }
        return success;
    }

    public FlightSection findSection(SeatClass s){
        if(sections.get(s) != null){
            return sections.get(s);
        }
        else{
            System.err.println("Section non trouvée");
            return null;
        }
    }

    public void bookSeat(SeatClass s, int row,char col){
        if(sections.get(s) != null) {
            findSection(s).bookSeat(new SeatID(row, col));
            //sections.get(s).bookSeat(new SeatID(row,col));
        }
        else{
            System.err.println("La section n'existe pas.");
        }
    }

    public Airport getDestination() {
        return destination;
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

    public Airline getAirline() {
        return airline;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightDate=" + flightDate +
                ", flightID='" + flightID + '\'' +
                ", sections=" + sections +
                ", airline=" + airline +
                ", destination=" + destination +
                ", origin=" + origin +
                '}';
    }
}
