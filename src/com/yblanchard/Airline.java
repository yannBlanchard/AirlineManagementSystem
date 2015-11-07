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

    public Flight createFlight(Airport orig,Airport dest, int year,int month,int day,String id){
        //Création de la calendar date
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(year,month,day);

        //Vérification
        if(flights.get(id) == null){
            return flights.put(id,new Flight(calendar,id,dest,orig));

        }else{

            System.out.println("L'id " + id + "existe deja.");
            return null;
        }
        //Création du vol
    }


    public Flight findFlight(String n){
        if (flights.get(n) != null) {
            return flights.get(n);
        }
        else {
            System.out.println("No flight found.");
            return null;
        }
    }
}
