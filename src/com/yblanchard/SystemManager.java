package com.yblanchard;

import java.util.ArrayList;
import java.util.List;

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

    private SystemManager() {


    }
}
