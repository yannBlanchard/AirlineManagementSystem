package com.yblanchard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yann on 01/11/2015.
 */
public class FlightSection {
    private SeatClass section;
    private List<Seat> seats = new ArrayList<Seat>();
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
