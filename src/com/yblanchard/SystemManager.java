package com.yblanchard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * Created by Yann on 31/10/2015.
 */
public class SystemManager{
    private List<Airline> airlines = new ArrayList<Airline>();
    private List<Airport> airports = new ArrayList<Airport>();


    private static SystemManager ourInstance = new SystemManager();

    public static SystemManager getInstance() {
        return ourInstance;
    }

    private SystemManager() {}

    public void createAirport(String n){

        int a =  airlines.stream().filter(e -> e.getName() == n);
        System.out.println(a);
        /*if(air.size() == 0)
            airports.add(new Airport(n));
        else
            System.out.println("Erreur");*/
    }

    public void createAirline(String n){
        airlines.add(new Airline(n));
    }

    public void createFlight(String n,String orig,String dest, int year,int month,int day,String id){
        for(Airline airline : airlines){
            System.out.println(airline.getName());
            if(airline.getName().equals(n)) {
                //airline.createFlight(orig,dest,year,month,day,id);
            }
        }

        List<Airline>air = new ArrayList<Airline>();
        airlines.stream().filter(e -> e.getName() == n).forEach(air :: add);

        //airlines.stream().forEach(x -> System.out.println());

    }


}
