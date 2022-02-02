package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogSome {
    //    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final Logger logger = LoggerFactory.getLogger(LogSome.class.getName());

    public static void main(String[] args) {
        logger.info("Hello world");

        String newVal = "val1", below = "val2", above = "val3";
        logger.debug("Value {} was inserted between {} and {}.", newVal, below, above);
    }

}
