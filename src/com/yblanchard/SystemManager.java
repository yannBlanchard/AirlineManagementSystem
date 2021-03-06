package com.yblanchard;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Yann on 31/10/2015.
 */
public class SystemManager{
    //private List<Airline> airlines = new ArrayList<Airline>();
    private Map<String, Airline> airlines = new HashMap<>();
    private Map<String, Airport> airports = new HashMap<>();
    //private List<Airport> airports = new ArrayList<Airport>();


    private static SystemManager ourInstance = new SystemManager();

    public static SystemManager getInstance() {
        return ourInstance;
    }

    private SystemManager() {}

    public boolean createAirport(String n){
        Boolean success = false;
        //On vérifie la taille de n
        if(n.length()==3) {
            //Si l'airport n'existe pas deja
            if (airports.get(n) == null) {
                airports.put(n, new Airport(n));
                success = true;

            } else {
                System.err.println("L'airport " + n + " existe deja.");
            }
        }else{
            System.err.println("Le nombre de caractere doit être strictement égale à 3.");
        }
        return success;
    }

    public boolean createAirline(String n){
        Boolean success = false;
        //On vérifie la taille
        if(n.length()<=5){
            //Si l'airline n'existe pas
            if(airlines.get(n) == null){
                airlines.put(n,new Airline(n));
                success = true;
            }
            else{
                System.err.println("L'airline " + n + " existe deja.");
            }
        }else{
            System.err.println("Le nombre de caractere doit être inférieur ou égale à 5.");
        }
        return success;
    }

    public boolean createFlight(String n,String orig,String dest, int year,int month,int day,String id){
        Boolean success = false;
        //List<Airline>air = new ArrayList<Airline>();
        //air.addAll(airlines.stream().filter(e -> e.getName().equals(n)).collect(Collectors.toList()));
        //airlines.stream().filter(e -> e.getName().equals(n)).map();

        //Ajouter test sur l'origine et la destination
        if(airlines.get(n) != null){
            if(airports.get(orig) != null && airports.get(dest)!=null) {
                if(airlines.get(n).createFlight(airports.get(orig), airports.get(dest), year, month, day, id) != null){
                    success = true;
                }
                else{
                    success = false;
                }
            }
            else{
                success = false;
                System.err.println("L'origine ou la destination n'existe pas.");
            }
        }
        else{

            success = false;
            System.err.println("L'airline n'existe pas.");
        }
        return success;
    }

    public boolean createSection(String air,String fID,int rows, int cols, SeatClass s){
        Boolean success;
        Flight flight;
        if(airlines.get(air) != null) {
            flight = airlines.get(air).findFlight(fID);
            if(flight != null){
                if(flight.createSection(rows, cols, s) == true) {
                    success = true;
                }else{
                    success = false;
                }
            }else{
                success= false;
            }
        }else{
            System.err.println("La compagnie n'existe pas.");
            success = false;
        }
        return success;
    }

    public boolean findAvailableFlights(String orig,String dest){
        boolean success = false;
        Iterator iterator = airlines.keySet().iterator();
        String cle;
        List<Flight> availableFlight;
        while (iterator.hasNext()){
            cle = (String)iterator.next();
            System.out.println(cle);
            availableFlight = airlines.get(cle).getAvailableFlights(airports.get(orig), airports.get(dest));
            if(availableFlight.size() != 0) {
                availableFlight.stream().forEach(System.out::println);
                success = true;
            }
            //success = (availableFlight !=null)?true:false;
        }
        return success;
    }

    public boolean bookSeat(String air,String fl,SeatClass s,int row,char col){
        boolean success = false;
        if(airlines.get(air) != null) {
            success =airlines.get(air).bookFlight(fl, s, row, col);
            //airlines.get(air).findFlight(fl).findSection(s).bookSeat(new SeatID(row,col)); //.bookSeat(s,row,col);
        }else{
            System.err.println("La compagnie n'existe pas.");
            success = false;
        }
        return success;
    }

    public boolean bookSeat(String air,String fl,SeatClass s){
        boolean success = false;
        if(airlines.get(air) != null) {
            success =airlines.get(air).bookFlight(fl, s);
            //airlines.get(air).findFlight(fl).findSection(s).bookSeat(new SeatID(row,col)); //.bookSeat(s,row,col);
        }else{
            System.err.println("La compagnie n'existe pas.");
            success = false;
        }
        return success;
    }

    public void displaySystemDetails(){
        Iterator iterator = airports.keySet().iterator();
        String cle;
        System.out.println("------------- Liste des aeroport -------------");
        while (iterator.hasNext()){
            cle = (String)iterator.next();
            System.out.println(airports.get(cle).toString());
        }
        System.out.println("------------- Liste des compagnie -------------");
        iterator = airlines.keySet().iterator();
        while (iterator.hasNext()){
            cle = (String)iterator.next();
            System.out.println(airlines.get(cle).toString());
        }
    }

}
