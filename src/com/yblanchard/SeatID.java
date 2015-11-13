package com.yblanchard;

/**
 * Created by Yann on 01/11/2015.
 */
public class SeatID {
    private Integer row;
    private char column;

    public SeatID(Integer row, char column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "" + row+column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeatID)) return false;

        SeatID seatID = (SeatID) o;

        if (column != seatID.column) return false;
        return !(row != null ? !row.equals(seatID.row) : seatID.row != null);

    }

    @Override
    public int hashCode() {
        int result = row != null ? row.hashCode() : 0;
        result = 31 * result + (int) column;
        return result;
    }
}
