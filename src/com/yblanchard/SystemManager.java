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
                System.out.println("L'airport " + n + " existe deja.");
            }
        }else{
            System.out.println("Le nombre de caractere doit être strictement égale à 3.");
        }
        return success;
    }

    public void createAirline(String n){
        //On vérifie la taille
        if(n.length()<=5){
            //Si l'airline n'existe pas
            if(airlines.get(n) == null){
                airlines.put(n,new Airline(n));
            }
            else{
                System.out.println("L'airline " + n + " existe deja.");
            }
        }else{
            System.out.println("Le nombre de caractere doit être inférieur ou égale à 5.");
        }
    }

    public void createFlight(String n,String orig,String dest, int year,int month,int day,String id){

        //List<Airline>air = new ArrayList<Airline>();
        //air.addAll(airlines.stream().filter(e -> e.getName().equals(n)).collect(Collectors.toList()));
        //airlines.stream().filter(e -> e.getName().equals(n)).map();

        //Ajouter test sur l'origine et la destination
        if(airlines.get(n) == null){
            System.out.println("L'airline n'existe pas.");
        }
        else{
            airlines.get(n).createFlight(airports.get(orig), airports.get(dest), year, month, day, id);
        }
    }

    public void createSection(String air,String fID,int rows, int cols, SeatClass s){
        airlines.get(air).findFlight(fID).createSection(rows, cols, s);
    }

    public void findAvailableFlights(String orig,String dest){
        Iterator<Airline> iterator = airlines.values().iterator();
        while (iterator.hasNext()){
            iterator.next();
            airlines.get(iterator).getAvailableFlights(airports.get(orig),airports.get(dest));
        }
    }

    public void bookSeat(String air,String fl,SeatClass s,int row,char col){
        airlines.get(air).findFlight(fl).findSection(s).bookSeat(new SeatID(row,col)); //.bookSeat(s,row,col);
    }

    public void displaySystemDetails(){
        Iterator<Airline> iterator = airlines.values().iterator();
        while (iterator.hasNext()){
            iterator.next();
            airlines.get(iterator);
        }
    }

}
