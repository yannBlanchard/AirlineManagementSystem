package com.yblanchard;

/**
 * Created by Yann on 01/11/2015.
 */


public class Airport {
    private String code;

    public Airport(String code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return code;
    }
}
