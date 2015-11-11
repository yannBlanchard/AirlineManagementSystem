package com.yblanchard;

import java.util.*;

/**
 * Created by Yann on 01/11/2015.
 */
public class FlightSection {
    private SeatClass section;
    private Map<String, Seat> seats = new HashMap<>();
    //private List<Seat> seats = new ArrayList<Seat>();
    public SeatClass getSeatClass(){
        return section;
    }

    public FlightSection(SeatClass section) {
        this.section = section;
    }


    public FlightSection(SeatClass section,int rows,int cols) {
        SeatID seatID;
        char col = 'A';
        this.section = section;
        if(rows <=100 && cols <=10) {
            //Cr�ation des rang�es
            for (int i = 1; i <= rows; i++) {
                //Cr�ation des si�ges
                for (int j = 1; j < cols; j++) {
                    seatID = new SeatID(i, col);
                    seats.put("" + i + col, new Seat(seatID, false));
                    col++;
                }
            }
        }else{
            System.err.println("Le nombre de siège par rangées doit être inférieur ou égale à 100 et le nombre de rangèe doit être inférieur ou égale à 10");
        }
    }

    public void bookSeat(){
        Iterator<Seat> iterator = seats.values().iterator();
        if(hasAvailableSeats() == true){
            //On recherche le premier siége de libre
            while (iterator.hasNext()){
                iterator.next();
                //S'il n'est pas déjà réservé alors on le réserve
                if(seats.get(iterator).getStatus().equals(false)){
                    seats.get(iterator).setIsBooked(true);
                }
            }

        }
        else{
            System.err.println("Pas de siége disponible.");
        }
    }

    public boolean bookSeat(SeatID sID){
        Boolean success = false;
        if(seats.get(sID) != null) {
            if(seats.get(sID).getStatus().equals(false)) {
                seats.get(sID).setIsBooked(true);
                success = true;
            }else{
                System.err.println("Le siége est déjà réservé.");
                success = false;
            }
        }
        else{
            System.err.println("L'id du siége n'existe pas.");
            success = false;
        }
        return success;
    }

    public boolean hasAvailableSeats(){
        Iterator<Seat> iterator = seats.values().iterator();
        while (iterator.hasNext()){
            iterator.next();
            if(seats.get(iterator).getStatus().equals(false)){
                return true;
            }
        }
        return false;
    }

}
