package com.yblanchard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yann on 01/11/2015.
 */
public class Airline{
    private String name;
    private List Flights = new ArrayList();

    public List getAvailableFlights(){
        return Flights;
    }

    public boolean bookFlight(){
        return false;
    }



}
