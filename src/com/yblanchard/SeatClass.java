package com.yblanchard;

/**
 * Created by Yann on 01/11/2015.
 */
public enum SeatClass {
    FIRST("First"),
    BUSI("Business"),
    ECO("Economy");

    SeatClass(String name) {
        this.name = name;
    }

    /*public String getName() {
        return name;
    }
    */
    private String name;

}
