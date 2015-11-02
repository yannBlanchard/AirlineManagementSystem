package com.yblanchard;

/**
 * Created by Yann on 01/11/2015.
 */
public class FlightSection {
    private SeatClass section;

    public SeatClass getSeatClass(){
        return section;
    }

    public boolean hasAvailableSeats(){
        return false;
    }

    public boolean bookSeat(){
        return false;
    }
}
