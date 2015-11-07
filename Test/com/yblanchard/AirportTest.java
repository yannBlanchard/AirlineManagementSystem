package com.yblanchard;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Objects;

import static org.testng.Assert.*;

/**
 * Created by Yann on 07/11/2015.
 */
public class AirportTest {

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    /*@DataProvider(name = "AirportAlreadyExist")
    public Iterator<Object[]> createLossData() {
        return new Object[]{
                "ROCK", "SCISSORS"
        };
    }

    @Test(dataProvider = "WinData")
    public void testWinPlay(String p1,String p2) throws Exception {
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.WIN);

    }*/

}