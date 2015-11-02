package com.yblanchard;

/**
 * Created by Yann on 31/10/2015.
 */
public class SystemManager{
    private static SystemManager ourInstance = new SystemManager();

    public static SystemManager getInstance() {
        return ourInstance;
    }

    private SystemManager() {


    }
}
