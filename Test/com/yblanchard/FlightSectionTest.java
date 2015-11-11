package com.yblanchard;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.*;

/**
 * Created by Yann on 11/11/2015.
 */
public class FlightSectionTest {
    private SystemManager res;
    @BeforeMethod
    public void setUp() throws Exception {
        res  = SystemManager.getInstance();
        res.createAirport("DEN");
        res.createAirport("CDG");
        res.createAirline("AIRFR");
        res.createFlight("AIRFR","DEN","CDG",2015,10,11,"123");
        res.createSection("AIFR","123",3,2,SeatClass.BUSI);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        res = null;
    }



}