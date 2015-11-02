package com.yblanchard;

/**
 * Created by Yann on 01/11/2015.
 */
public class Seat {
    private SeatID seatNum;
    private Boolean isBooked;

    public Boolean getStatus() {
        return isBooked;
    }

    public SeatID getSeatNum() {
        return seatNum;
    }
}
