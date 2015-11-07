package com.yblanchard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        //Création des rangées
        for(int i =1;i<=rows;i++){
            //Création des siéges
            for(int j= 1;j<cols;j++){
                seatID = new SeatID(i,col);
                seats.put(""+i + col, new Seat(seatID,false));
                col++;
                System.out.println(seatID);
            }
        }
    }

    public boolean hasAvailableSeats(){
        return false;
    }

    public boolean bookSeat(){
        return false;
    }
}
