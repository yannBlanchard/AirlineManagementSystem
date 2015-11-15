package com.yblanchard;

import java.util.*;

/**
 * Created by Yann on 01/11/2015.
 */
public class FlightSection {
    private SeatClass section;
    private Map<SeatID, Seat> seats = new HashMap<>();
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
            if(rows > 0 && cols > 0) {
                //Cr�ation des rang�es
                for (int i = 1; i <= rows; i++) {
                    //Cr�ation des si�ges
                    col = 'A';
                    for (int j = 1; j <= cols; j++) {
                        seatID = new SeatID(i, col);
                        seats.put(seatID, new Seat(seatID, false));
                        col++;
                    }
                }
            }else{
                System.err.println("Le nombre de siège par rangées doit être supérieur à 0 et le nombre de rangèe doit être supérieur à 0");
            }
        }else{
            System.err.println("Le nombre de siège par rangées doit être inférieur ou égale à 100 et le nombre de rangèe doit être inférieur ou égale à 10");
        }
    }

    public boolean bookSeat(){
        boolean success = false;
        Iterator iterator = seats.keySet().iterator();
        SeatID cle;
        if(hasAvailableSeats() == true){
            //On recherche le premier siége de libre
            while (iterator.hasNext()){
                cle = (SeatID)iterator.next();
                //S'il n'est pas déjà réservé alors on le réserve
                if(seats.get(cle).getStatus().equals(false)){
                    seats.get(cle).setIsBooked(true);
                    success = true;
                    return success;
                }
            }
            success = false;
        }
        else{
            System.err.println("Pas de siége disponible.");
            success = false;
        }
        return success;
    }

    public boolean bookSeat(SeatID sID){
        Boolean success = false;
        if(seats.get(sID) != null) {
            if(!seats.get(sID).getStatus()) {
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
        Iterator iterator = seats.keySet().iterator();
        SeatID cle;
        while (iterator.hasNext()){
            cle =(SeatID) iterator.next();
            if(seats.get(cle).getStatus().equals(false)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String res;
        Iterator iterator = seats.keySet().iterator();
        SeatID cle;
        res = "----- Section "+ section + "-----\n";
        while (iterator.hasNext()){
            cle = (SeatID)iterator.next();
            res = res + seats.get(cle).toString() + "";
        }
        return res;
    }



}
