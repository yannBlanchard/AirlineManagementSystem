package com.yblanchard;

import org.testng.annotations.*;

import java.util.Iterator;
import java.util.Objects;

import static org.testng.Assert.*;

/**
 * Created by Yann on 07/11/2015.
 */
public class AirportTest {
    private SystemManager res;
    @BeforeMethod
    public void setUp() throws Exception {
        res  = SystemManager.getInstance();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        res = null;
    }

    @BeforeClass
    public void setUpClass() throws Exception{


    }


    @DataProvider(name = "DifferentAirport")
    public Object[][] createDifferentAirport() {
        return new Object[][]{
                {"DEN", true},
                {"DFW", true},
                {"LON", true}
        };
    }

    @DataProvider(name = "testNbCaractCreateAirport")
    public Object[][] testNbCaractCreateAirport() {
        return new Object[][]{
                {"DE", false},
                {"CDG", true},
                {"LOND", false}
        };
    }

    @DataProvider(name = "testAlreadyAirport")
    public Object[][] testAlreadyAirport() {
        return new Object[][]{
                {"JPN", true},
                {"JPN", false}
        };
    }

    /*@DataProvider(name = "AirportAlreadyExist")
    public Iterator<Object[]> createLossData() {
        return new Object[]{
                "DEN", "DEN"
        };
    }*/

    @Test(dataProvider = "DifferentAirport")
    public void test(String p1,boolean p2) throws Exception {
        assertEquals(res.createAirport(p1),p2);
    }
    @Test(dataProvider = "testNbCaractCreateAirport")
    public void testNbCaractCreateAirport(String p1,boolean p2) throws Exception {
        assertEquals(res.createAirport(p1),p2);
    }
    @Test(dataProvider = "testAlreadyAirport")
    public void testAlreadyAirport(String p1,boolean p2) throws Exception {
        assertEquals(res.createAirport(p1),p2);
    }
}