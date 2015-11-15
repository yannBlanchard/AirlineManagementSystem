package com.yblanchard;

public class ClientAMS {

    public static void main(String[] args) {
	// write your code here
        SystemManager res  = SystemManager.getInstance();
        //Create airport
        res.createAirport("DEN");
        res.createAirport("DFW");
        res.createAirport("LON");
        res.createAirport("DEN");
        res.createAirport("CDG");
        res.createAirport("JPN");
        res.createAirport("DEN");//invalide probleme d'unicité
        res.createAirport("AZ");//invalide taille inferieur à 3
        res.createAirport("DEH");
        res.createAirport("AZER");//invalide taille supérieur à 3

        //create airlines

        res.createAirline("DELTA");
        res.createAirline("AIRFR");
        res.createAirline("AMER");
        res.createAirline("JET");
        res.createAirline("DELTA");
        res.createAirline("SWEST");
        res.createAirline("FRONTIER");
        res.createAirline("SWEST"); // probleme d'unicité
        res.createAirline("EASY");

        //create flight
        res.createFlight("DELTA", "DEN","LON",2008,11,12,"789");
        res.createFlight("DELTA", "DEN","DEH",2009,8,9,"567");
        res.createFlight("DELTA", "DEN","NCE",2010,8,9,"567");//invalide NCE n'existe pas
        res.createFlight("DELTA", "ABC","LON",2010,8,9,"567");//invalide ABC n'existe pas
        res.createFlight("DELTA", "DEN","LON",2010,8,9,"123");//invalide id existe deja

        res.createFlight("JET", "CDG","DEN",2015,11,10,"123");
        res.createFlight("AIRFR", "CDG","DEN",2015,11,10,"234");
        res.createFlight("AIRFR", "CDG","DEN",2015,11,10,"234");//l'id existe deja
        res.createFlight("EASY", "LON","DEN",2015,11,10,"147");
        res.createFlight("JET", "CDG", "DEN", 2015, 11, 10, "486");
        res.createFlight("WXC", "CDG", "DEN", 2015, 11, 10, "456");
        //create section
        res.createSection("JET","123",2,2,SeatClass.ECO);
        res.createSection("JET","123",1,3,SeatClass.ECO); // Erreur eco existe deja
        res.createSection("JET","123",2,3,SeatClass.FIRST);
        res.createSection("DELTA","123",2,3,SeatClass.FIRST);
        res.createSection("DELTA","123",1,2,SeatClass.BUSI);
        res.createSection("AIRFR","234",6,3,SeatClass.BUSI);
        res.createSection("AIRFR","234",0,3,SeatClass.ECO);//erreur nombre de colonne doit être supérieur à 0
        res.createSection("AIRFR","234",101,3,SeatClass.ECO);//erreur nombre de colonne doit être inférieur à 100
        res.createSection("AIRFR","234",6,0,SeatClass.ECO); //erreur nombre de siege doit être supérieur à 0
        res.createSection("EASY","147",2,3,SeatClass.FIRST);
        res.createSection("EASY","235",2,3,SeatClass.FIRST);// l'id n'existe pas
        res.createSection("UGHGFUJ","147",2,3,SeatClass.FIRST);// erreur compagnie n'existe pas

        res.displaySystemDetails();


        res.findAvailableFlights("DEN", "LON");

        res.bookSeat("DELTA", "123", SeatClass.BUSI, 1, 'A');
        res.bookSeat("DELTA", "123", SeatClass.ECO, 1, 'A'); //section existe pas
        res.bookSeat("DELTA", "156", SeatClass.ECO, 1, 'A'); //vol n'existe pas
        res.bookSeat("DELTA","123",SeatClass.BUSI,1,'B');
        res.bookSeat("DELTA","123",SeatClass.BUSI,1,'K');//id du siege non trouvé
        res.bookSeat("WXCV","123",SeatClass.BUSI,1,'B'); // la compagnie n'existe pas
        res.bookSeat("DELTA","123",SeatClass.BUSI,1,'A'); // deja reservé
        res.bookSeat("AIRFR","234",SeatClass.ECO,1,'A'); // section non trouvé



        res.bookSeat("DELTA","123",SeatClass.FIRST);
        res.bookSeat("JET","123",SeatClass.BUSI);//la section n'existe pas
        res.bookSeat("JET","987",SeatClass.BUSI);//le vol n'existe pas
        res.bookSeat("QSDF","123",SeatClass.FIRST);//erreur compagnie existe pas


        res.displaySystemDetails();

        res.findAvailableFlights("DEN","LON");

        //book seat
        //res.bookSeat("AIRFR","234",SeatClass.BUSI,6,'C');
        //res.bookSeat("AIRFR","234",SeatClass.BUSI);
        //display system
        //res.displaySystemDetails();


    }
}
