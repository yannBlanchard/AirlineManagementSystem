package com.yblanchard;

import java.util.*;

/**
 * Created by Yann on 01/11/2015.
 */
public class Flight {

    private Calendar flightDate;
    private String flightID;
    //private List<FlightSection> sections = new ArrayList<FlightSection>();
    private Map<SeatClass, FlightSection> sections = new HashMap<>();
    private Airline airline;
    private Airport destination;
    private Airport origin;


    public Flight(String flightID, Calendar flightDate) {
        this.flightID = flightID;
        this.flightDate = flightDate;
    }

    public Flight(Calendar flightDate, String flightID, Airport destination, Airport origin) {
        this.flightDate = flightDate;
        this.flightID = flightID;
        this.destination = destination;
        this.origin = origin;
    }


    public boolean createSection(int rows,int cols,SeatClass s){
        Boolean success = false;
        //Création de la section
        if(sections.get(s) == null) {
            if(rows <=100 && cols <=10) {
                if(rows > 0 && cols > 0) {
                    sections.put(s, new FlightSection(s, rows, cols));
                    success = true;
                }else{
                    System.err.println("Le nombre de siège par rangées doit être supérieur à 0 et le nombre de rangèe doit être supérieur à 0");
                    success = false;
                }
            }else{
                System.err.println("Le nombre de siège par rangées doit être inférieur ou égale à 100 et le nombre de rangèe doit être inférieur ou égale à 10");
                success = false;
            }
        }else{
            System.err.println("La section existe déjà.");
            success = false;
        }
        return success;
    }

    public FlightSection findSection(SeatClass s){
        if(sections.get(s) != null){
            return sections.get(s);
        }
        else{
            System.err.println("Section non trouvée");
            return null;
        }
    }

    public void bookSeat(SeatClass s, int row,char col){
        SeatID sID;
        if(sections.get(s) != null) {
            sID = new SeatID(row,col);
            findSection(s).bookSeat(sID);
            //findSection(s).bookSeat(new SeatID(row, col));
            //sections.get(s).bookSeat(new SeatID(row,col));
        }
        else{
            System.err.println("La section n'existe pas.");
        }
    }

    public Airport getDestination() {
        return destination;
    }

    public Airport getOrigin() {
        return origin;
    }

    public Calendar getFlightDate() {
        return flightDate;
    }

    public String getFlightID() {
        return flightID;
    }

    public Airline getAirline() {
        return airline;
    }

    @Override
    public String toString() {
        String res;
        Iterator iterator = sections.keySet().iterator();
        SeatClass cle;
        /*return "Flight{" +
                "flightDate=" + flightDate +
                ", flightID='" + flightID + '\'' +
                ", sections=" + sections +
                ", airline=" + airline +
                ", destination=" + destination +
                ", origin=" + origin +
                '}';*/
        res = "vol "+ flightID + " de la compagnie "+ airline + " au départ de " + origin.toString() +
                " et à destination de " + destination.toString() + ",départ à " + flightDate.getInstance().getTime() + "\n";

        while (iterator.hasNext()){
            cle = (SeatClass)iterator.next();
            res = res + findSection(cle).toString()+ "\n\n";
        }
        return res;
    }
}
