package com.yblanchard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Yann on 01/11/2015.
 */
public class Airline{
    public String getName() {
        return name;
    }

    private String name;
    private List<Flight> Flights = new ArrayList<Flight>();

    public List getAvailableFlights(){
        return Flights;
    }

    public boolean bookFlight(){
        return false;
    }

    public Airline(String name) {
        this.name = name;
    }

    /*public Flight createFlight(String orig,String dest, int year,int month,int day,String id){
        //Création de la calendar date
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(year,month,day);
        //Création du vol

        //return Flights.add(new Flight(calendar,id,dest,orig));
    }*/

}
