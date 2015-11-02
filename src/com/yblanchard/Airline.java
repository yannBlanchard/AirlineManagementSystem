package com.yblanchard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Yann on 01/11/2015.
 */
public class Airline{
    private String name;
    private List<Flight> Flights = new ArrayList<Flight>();

    public List getAvailableFlights(){
        return Flights;
    }

    public boolean bookFlight(){
        return false;
    }



}
