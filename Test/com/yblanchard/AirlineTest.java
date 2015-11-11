package com.yblanchard;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.*;

/**
 * Created by Yann on 11/11/2015.
 */
public class AirlineTest {
    private SystemManager res;
    @BeforeMethod
    public void setUp() throws Exception {
        res  = SystemManager.getInstance();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        res = null;
    }

    @BeforeClass
    public void setUpClass() throws Exception{

    }



}