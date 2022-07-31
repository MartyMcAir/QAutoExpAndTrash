package com;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// https://www.baeldung.com/java-logging-intro
// https://logging.apache.org/log4j/2.x/manual/appenders.html
public class SomeClass {
    private static final Logger rootLogger = LogManager.getRootLogger(), userLogger = LogManager.getLogger(SomeClass.class);

    public static void main(String[] args) {
        userLogger.info("Hello World");

        if (rootLogger.isDebugEnabled()) {
            userLogger.debug("UserLogger in debug");
        }

        String newVal = "val1", below = "val2", above = "val3";
        userLogger.debug("Value {} was inserted between {} and {}.", newVal, below, above);
    }

}
