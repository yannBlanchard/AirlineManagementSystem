package com.yblanchard;

import java.util.*;

/**
 * Created by Yann on 01/11/2015.
 */
public class Airline{
    public String getName() {
        return name;
    }

    private String name;
    private Map<String, Flight> flights = new HashMap<>();
    //private List<Flight> Flights = new ArrayList<Flight>();

    public Map getAvailableFlights(){
        return flights;
    }

    public boolean bookFlight(){
        return false;
    }

    public Airline(String name) {
        this.name = name;
    }

    public Flight createFlight(String orig,String dest, int year,int month,int day,String id){
        //Cr�ation de la calendar date
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(year,month,day);

        //V�rification
        if(flights.get(id) == null){
            System.out.println("L'id " + id + "existe deja.");
        }else{
            return flights.put(id,new Flight(id,calendar));
        }
        //Cr�ation du vol

        return null;
    }

}
