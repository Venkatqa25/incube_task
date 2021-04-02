package com.qa.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestUtils {

    public static final long WAIT =10;

    public Logger log(){

        //It basically initialize the log4j2 using the getlogger method and this is class Thread.currentThread().
        // getStackTrace()[2].getClassName() sending to the logger basically it print the log statement along with
        // corresponding class name and returning the logger objects which can use print our logs
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());

    }



}
