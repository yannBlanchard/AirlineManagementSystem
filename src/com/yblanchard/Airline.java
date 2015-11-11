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


    public Airline(String name) {
        this.name = name;
    }

    public Flight createFlight(Airport orig,Airport dest, int year,int month,int day,String id){
        Flight flight;
        //Création de la calendar date
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(year,month,day);
        //Vérification de l'id
        if(flights.get(id) == null){
            flight = new Flight(calendar,id,dest,orig);
            flights.put(id,flight);
            return flight;

        }else{
            System.err.println("L'id " + id + "existe deja.");
            return null;
        }
    }


    public Flight findFlight(String n){
        if (flights.get(n) != null) {
            return flights.get(n);
        }
        else {
            System.err.println("No flight found.");
            return null;
        }
    }

    public List<Flight> getAvailableFlights(Airport orig,Airport dest){
        Boolean find = false;
        List<Flight> availableFlight = new ArrayList<>();
        Iterator iterator = flights.values().iterator();
        while (iterator.hasNext()){
            iterator.next();
            //Si il existe un vol avec l'origine et la destination passé en paramettre
            if(flights.get(iterator).getOrigin().equals(orig) && flights.get(iterator).getDestination().equals(dest)){
                availableFlight.add(flights.get(iterator));
                find = true;
            }
        }
        if(find == false){
            System.err.println("No flight available.");
        }

        return availableFlight;
    }

    public void bookFlight(String fl,SeatClass s,int row,char col){
        flights.get(fl).bookSeat(s,row,col);
    }

}
