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
            System.err.println("L'id " + id + " existe deja.");
            return null;
        }
    }


    public Flight findFlight(String n){
        if (flights.get(n) != null) {
            return flights.get(n);
        }
        else {
            System.err.println("Vol non trouvé.");
            return null;
        }
    }

    public List<Flight> getAvailableFlights(Airport orig,Airport dest){
        String cle;
        List<Flight> availableFlight = new ArrayList<>();
        Iterator iterator = flights.keySet().iterator();
        while (iterator.hasNext()){
            cle = (String)iterator.next();
            //Si il existe un vol avec l'origine et la destination passé en paramettre
            if(flights.get(cle).getOrigin().equals(orig) && flights.get(cle).getDestination().equals(dest)){
                availableFlight.add(flights.get(cle));
            }
        }

        return availableFlight;
    }

    public boolean bookFlight(String fl,SeatClass s,int row,char col){
        Boolean success= false;
        if(flights.get(fl) != null) {
            success =flights.get(fl).bookSeat(s, row, col);
            //success = true;
        }else{
            System.err.println("Le vol n'existe pas.");
            success = false;
        }
        return success;
    }

    @Override
    public String toString() {
        Iterator iterator = flights.keySet().iterator();
        String cle;
        String res;
        res = "------------- Compagnie " + name +" -------------\n";
        while (iterator.hasNext()){
            cle = (String)iterator.next();
            res = res + flights.get(cle).toString();
        }
        return name;
    }
}
