package com.yblanchard;

import org.testng.annotations.*;

import static org.testng.Assert.*;

/**
 * Created by Yann on 11/11/2015.
 */
public class SystemManagerTest {
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

    /*-----------------------------------------------------------------------------------
     *
     *                                Test createAirport
     *
     *----------------------------------------------------------------------------------*/
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

    @DataProvider(name = "testAirportAlreadyExist")
    public Object[][] testAirportAlreadyExist() {
        return new Object[][]{
                {"JPN", true},
                {"JPN", false}
        };
    }

    @Test(dataProvider = "DifferentAirport")
    public void DifferentAirport(String p1,boolean p2) throws Exception {
        assertEquals(res.createAirport(p1),p2);
    }
    @Test(dataProvider = "testNbCaractCreateAirport")
    public void testNbCaractCreateAirport(String p1,boolean p2) throws Exception {
        assertEquals(res.createAirport(p1),p2);
    }
    @Test(dataProvider = "testAirportAlreadyExist")
    public void testAirportAlreadyExist(String p1,boolean p2) throws Exception {
        assertEquals(res.createAirport(p1),p2);
    }

    /*-----------------------------------------------------------------------------------
     *
     *                                Test createAirline
     *
     *----------------------------------------------------------------------------------*/
    @DataProvider(name = "createDifferentAirline")
    public Object[][] createDifferentAirline() {
        return new Object[][]{
                {"DELTA", true},
                {"AIRFR", true},
                {"AMER", true}
        };
    }

    @DataProvider(name = "testNbCaractCreateAirline")
    public Object[][] testNbCaractCreateAirline() {
        return new Object[][]{
                {"ABCDEF", false},
                {"EASY", true},
                {"AIRWAYS", false}
        };
    }

    @DataProvider(name = "testAirlineAlreadyExist")
    public Object[][] testAirlineAlreadyExist() {
        return new Object[][]{
                {"JET", true},
                {"JET", false}
        };
    }

    @Test(dataProvider = "createDifferentAirline")
    public void createDifferentAirline(String p1,boolean p2) throws Exception {
        assertEquals(res.createAirline(p1),p2);
    }
    @Test(dataProvider = "testNbCaractCreateAirline")
    public void testNbCaractCreateAirline(String p1,boolean p2) throws Exception {
        assertEquals(res.createAirline(p1),p2);
    }
    @Test(dataProvider = "testAirlineAlreadyExist")
    public void testAirlineAlreadyExist(String p1,boolean p2) throws Exception {
        assertEquals(res.createAirline(p1),p2);
    }
    /*-----------------------------------------------------------------------------------
     *
     *                                Test createFlight
     *
     *----------------------------------------------------------------------------------*/
    @DataProvider(name = "createDifferentFlight")
    public Object[][] createDifferentFlight() {
        return new Object[][]{
                {"DELTA","DEN","DFW",2015,10,10,"123",true},
                {"AIRFR","DFW","LON",2015,11,5,"234",true}
        };
    }

    @DataProvider(name = "destinationExistePas")
    public Object[][] destinationExistePas() {
        return new Object[][]{
                {"DELTA","DEN","ABC",2015,10,10,"345",false},
                {"AIRFR","DFW","LON",2015,11,5,"456",true}
        };
    }

    @DataProvider(name = "origineExistePas")
    public Object[][] origineExistePas() {
        return new Object[][]{
                {"DELTA","DEF","LON",2015,10,10,"345",false},
                {"AIRFR","DFW","LON",2015,11,5,"456",true}
        };
    }
    @DataProvider(name = "idExisteDeja")
    public Object[][] idExisteDeja() {
        return new Object[][]{
                {"DELTA","DEN","LON",2015,10,10,"567",true},
                {"AIRFR","DFW","LON",2015,11,5,"567",false}
        };
    }
    @DataProvider(name = "AirlineExistePas")
    public Object[][] AirlineExistePas() {
        return new Object[][]{
                {"DELTA","DEN","LON",2015,10,10,"567",true},
                {"QSDF","DFW","LON",2015,11,5,"567",false}
        };
    }

    @Test(dataProvider = "createDifferentFlight")
    public void createDifferentFlight(String p1,String p2,String p3,int i1,int i2,int i3,String p4,boolean b1) throws Exception {
        assertEquals(res.createFlight(p1, p2, p3, i1, i2,i3,p4),b1);
    }

    @Test(dataProvider = "origineExistePas")
    public void origineExistePas(String p1,String p2,String p3,int i1,int i2,int i3,String p4,boolean b1) throws Exception {
        assertEquals(res.createFlight(p1, p2, p3, i1, i2,i3,p4),b1);
    }

    @Test(dataProvider = "idExisteDeja")
    public void idExisteDeja(String p1,String p2,String p3,int i1,int i2,int i3,String p4,boolean b1) throws Exception {
        assertEquals(res.createFlight(p1, p2, p3, i1, i2,i3,p4),b1);
    }

    @Test(dataProvider = "AirlineExistePas")
    public void AirlineExistePas(String p1,String p2,String p3,int i1,int i2,int i3,String p4,boolean b1) throws Exception {
        assertEquals(res.createFlight(p1, p2, p3, i1, i2,i3,p4),b1);
    }

}