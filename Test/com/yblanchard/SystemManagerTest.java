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

    @Test(dataProvider = "DifferentAirport",groups = { "airport" })
    public void DifferentAirport(String p1,boolean p2) throws Exception {
        assertEquals(res.createAirport(p1),p2);
    }
    @Test(dataProvider = "testNbCaractCreateAirport",groups = { "airport" })
    public void testNbCaractCreateAirport(String p1,boolean p2) throws Exception {
        assertEquals(res.createAirport(p1),p2);
    }
    @Test(dataProvider = "testAirportAlreadyExist",groups = { "airport" })
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

    @Test(dataProvider = "createDifferentAirline",groups = { "airline" },dependsOnGroups = { "airport.*" })
    public void createDifferentAirline(String p1,boolean p2) throws Exception {
        assertEquals(res.createAirline(p1),p2);
    }
    @Test(dataProvider = "testNbCaractCreateAirline",groups = { "airline" },dependsOnGroups = { "airport.*" })
    public void testNbCaractCreateAirline(String p1,boolean p2) throws Exception {
        assertEquals(res.createAirline(p1),p2);
    }
    @Test(dataProvider = "testAirlineAlreadyExist",groups = { "airline" },dependsOnGroups = { "airport.*" })
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
                {"AIRFR", "CDG","DEN",2015,11,10,"197",true},
                {"AIRFR", "CDG","DEN",2015,11,10,"197",false}
        };
    }
    @DataProvider(name = "AirlineExistePas")
    public Object[][] AirlineExistePas() {
        return new Object[][]{
                {"DELTA","DEN","LON",2015,10,10,"987",true},
                {"QSDF","DFW","LON",2015,11,5,"963",false}
        };
    }

    @Test(dataProvider = "createDifferentFlight",groups = { "flight" },dependsOnGroups = { "airline.*" })
    public void createDifferentFlight(String p1,String p2,String p3,int i1,int i2,int i3,String p4,boolean b1) throws Exception {
        assertEquals(res.createFlight(p1, p2, p3, i1, i2,i3,p4),b1);
    }

    @Test(dataProvider = "origineExistePas",groups = { "flight" },dependsOnGroups = { "airline.*" })
    public void origineExistePas(String p1,String p2,String p3,int i1,int i2,int i3,String p4,boolean b1) throws Exception {
        assertEquals(res.createFlight(p1, p2, p3, i1, i2,i3,p4),b1);
    }

    @Test(dataProvider = "idExisteDeja",groups = { "flight" },dependsOnGroups = { "airline.*" })
    public void idExisteDeja(String p1,String p2,String p3,int i1,int i2,int i3,String p4,boolean b1) throws Exception {
        assertEquals(res.createFlight(p1, p2, p3, i1, i2,i3,p4),b1);
    }

    @Test(dataProvider = "AirlineExistePas",groups = { "flight" },dependsOnGroups = { "airline.*" })
    public void AirlineExistePas(String p1,String p2,String p3,int i1,int i2,int i3,String p4,boolean b1) throws Exception {
        assertEquals(res.createFlight(p1, p2, p3, i1, i2,i3,p4),b1);
    }

    /*-----------------------------------------------------------------------------------
     *
     *                                Test section
     *
     *----------------------------------------------------------------------------------*/
    @DataProvider(name = "createDifferentSection")
    public Object[][] createDifferentSection() {
        return new Object[][]{
                {"AIRFR","456",2,2,SeatClass.BUSI,true},
                {"AIRFR","456",2,2,SeatClass.ECO,true}
        };
    }
    @Test(dataProvider = "createDifferentSection",groups = { "section" },dependsOnGroups = { "flight.*" })
    public void createDifferentSection(String p1,String p2,int i1,int i2,SeatClass s1,boolean b1) throws Exception {
        assertEquals(res.createSection(p1, p2, i1, i2, s1),b1);
    }

    @DataProvider(name = "flightIDExistePas")
    public Object[][] flightIDExistePas() {
        return new Object[][]{
                {"AIRFR","167",2,2,SeatClass.BUSI,false},
                {"AIRFR","345",2,2,SeatClass.ECO,false}
        };
    }
    @Test(dataProvider = "flightIDExistePas",groups = { "section" },dependsOnGroups = { "flight.*" })
    public void flightIDExistePas(String p1,String p2,int i1,int i2,SeatClass s1,boolean b1) throws Exception {
        assertEquals(res.createSection(p1,p2,i1,i2,s1),b1);
    }
    @DataProvider(name = "compagnieExistePas")
    public Object[][] compagnieExistePas() {
        return new Object[][]{
                {"TOTO","456",2,2,SeatClass.BUSI,false},
                {"TATA","456",2,2,SeatClass.ECO,false}
        };
    }
    @Test(dataProvider = "compagnieExistePas",groups = { "section" },dependsOnGroups = { "flight.*" })
    public void compagnieExistePas(String p1,String p2,int i1,int i2,SeatClass s1,boolean b1) throws Exception {
        assertEquals(res.createSection(p1,p2,i1,i2,s1),b1);
    }
    @DataProvider(name = "nombreDeSiegeEgaleInf0")
    public Object[][] nombreDeSiegeEgaleInf0() {
        return new Object[][]{
                {"AIRFR","234",1,0,SeatClass.BUSI,false},
                {"AIRFR","234",1,-1,SeatClass.BUSI,false},
                {"AIRFR","234",-1,3,SeatClass.BUSI,false},
                {"AIRFR","234",0,2,SeatClass.ECO,false}
        };
    }
    @Test(dataProvider = "nombreDeSiegeEgaleInf0",groups = { "section" },dependsOnGroups = { "flight.*" })
    public void nombreDeSiegeEgaleInf0(String p1,String p2,int i1,int i2,SeatClass s1,boolean b1) throws Exception {
        assertEquals(res.createSection(p1,p2,i1,i2,s1),b1);
    }
    @DataProvider(name = "nbRangeSuperieur100")
    public Object[][] nbRangeSuperieur100() {
        return new Object[][]{
                {"DELTA","123",110,2,SeatClass.BUSI,false},
                {"DELTA","123",101,2,SeatClass.ECO,false}
        };
    }
    @Test(dataProvider = "nbRangeSuperieur100",groups = { "section" },dependsOnGroups = { "flight.*" })
    public void nbRangeSuperieur100(String p1,String p2,int i1,int i2,SeatClass s1,boolean b1) throws Exception {
        assertEquals(res.createSection(p1,p2,i1,i2,s1),b1);
    }
    @DataProvider(name = "nbSiegeSuperieur10")
    public Object[][] nbSiegeSuperieur10() {
        return new Object[][]{
                {"DELTA","123",2,10,SeatClass.BUSI,true},
                {"DELTA","123",3,30,SeatClass.ECO,false}
        };
    }
    @Test(dataProvider = "nbSiegeSuperieur10",groups = { "section" },dependsOnGroups = { "flight.*" })
    public void nbSiegeSuperieur10(String p1,String p2,int i1,int i2,SeatClass s1,boolean b1) throws Exception {
        assertEquals(res.createSection(p1,p2,i1,i2,s1),b1);
    }

    /*-----------------------------------------------------------------------------------
     *
     *                                Test bookSeat
     *
     *----------------------------------------------------------------------------------*/

    @DataProvider(name = "reservationSiegeOk")
    public Object[][] reservationSiegeOk() {
        return new Object[][]{
                {"DELTA","123",SeatClass.BUSI,1,'A',true},
                {"DELTA","123",SeatClass.BUSI,1,'B',true}
        };
    }

    @Test(dataProvider = "reservationSiegeOk",groups = { "bookSeat" },dependsOnGroups = { "section.*" })
    public void reservationSiegeOk(String p1,String p2,SeatClass s,int i1,char c1,boolean b1) throws Exception {
        assertEquals(res.bookSeat(p1, p2, s, i1, c1),b1);
    }

    @DataProvider(name = "airlineExistePas")
    public Object[][] airlineExistePas() {
        return new Object[][]{
                {"TOTO","123",SeatClass.BUSI,1,'C',false},
                {"TUTU","123",SeatClass.BUSI,1,'D',false}
        };
    }

    @Test(dataProvider = "airlineExistePas",groups = { "bookSeat" },dependsOnGroups = { "section.*" })
    public void airlineExistePas(String p1,String p2,SeatClass s,int i1,char c1,boolean b1) throws Exception {
        assertEquals(res.bookSeat(p1,p2,s,i1,c1),b1);
    }

    @DataProvider(name = "flightIdExistePas")
    public Object[][] flightIdExistePas() {
        return new Object[][]{
                {"DELTA","159",SeatClass.BUSI,1,'C',false},
                {"DELTA","753",SeatClass.BUSI,1,'D',false}
        };
    }

    @Test(dataProvider = "flightIdExistePas",groups = { "bookSeat" },dependsOnGroups = { "section.*" })
    public void flightIdExistePas(String p1,String p2,SeatClass s,int i1,char c1,boolean b1) throws Exception {
        assertEquals(res.bookSeat(p1,p2,s,i1,c1),b1);
    }

    @DataProvider(name = "seatClassExistePas")
    public Object[][] seatClassExistePas() {
        return new Object[][]{
                {"DELTA","123",SeatClass.ECO,1,'C',false},
                {"DELTA","123",SeatClass.FIRST,1,'D',false}
        };
    }

    @Test(dataProvider = "seatClassExistePas",groups = { "bookSeat" },dependsOnGroups = { "section.*" })
    public void seatClassExistePas(String p1,String p2,SeatClass s,int i1,char c1,boolean b1) throws Exception {
        assertEquals(res.bookSeat(p1,p2,s,i1,c1),b1);
    }

    @DataProvider(name = "siegeExistePas")
    public Object[][] siegeExistePas() {
        return new Object[][]{
                {"DELTA","123",SeatClass.BUSI,3,'C',false},
                {"DELTA","123",SeatClass.BUSI,1,'K',false}
        };
    }

    @Test(dataProvider = "siegeExistePas",groups = { "bookSeat" },dependsOnGroups = { "section.*" })
    public void siegeExistePas(String p1,String p2,SeatClass s,int i1,char c1,boolean b1) throws Exception {
        assertEquals(res.bookSeat(p1,p2,s,i1,c1),b1);
    }

    @DataProvider(name = "verificationSiegeBienReserve")
    public Object[][] verificationSiegeBienReserve() {
        return new Object[][]{
                {"AIRFR","456",SeatClass.BUSI,2,'A',true},
                {"AIRFR","456",SeatClass.BUSI,2,'A',false}
        };
    }

    @Test(dataProvider = "verificationSiegeBienReserve",groups = { "bookSeat" },dependsOnGroups = { "section.*" })
    public void verificationSiegeBienReserve(String p1,String p2,SeatClass s,int i1,char c1,boolean b1) throws Exception {
        assertEquals(res.bookSeat(p1, p2, s, i1, c1), b1);
    }

    /*-----------------------------------------------------------------------------------
     *
     *                                Test findFlight
     *
     *----------------------------------------------------------------------------------*/

    @Test(groups = { "findFlight" },dependsOnGroups = { "bookSeat.*" })
    public void placeEncoreDisponible() throws Exception {
        res.createFlight("AIRFR","DEN","CDG",2015,10,11,"684");
        res.createSection("AIRFR", "684", 1, 2, SeatClass.BUSI);
        res.bookSeat("AIRFR", "684", SeatClass.BUSI, 1, 'A');
        assertEquals(res.findAvailableFlights("DEN", "CGD"),true);
    }


    @Test(groups = { "findFlight" },dependsOnGroups = { "bookSeat.*" })
    public void placeNonDisponible() throws Exception {
        res.createFlight("AIRFR","CDG","LON",2015,10,11,"642");
        res.createSection("AIRFR", "642", 1, 2, SeatClass.ECO);
        res.bookSeat("AIRFR", "642", SeatClass.ECO, 1, 'A');
        assertEquals(res.findAvailableFlights("CDG", "LON"), true);
        res.bookSeat("AIRFR", "642", SeatClass.ECO, 1, 'B');
        assertEquals(res.findAvailableFlights("CDG", "LON"), false);
    }
}