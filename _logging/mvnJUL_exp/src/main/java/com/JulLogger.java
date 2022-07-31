package com;

import java.util.logging.Level;
import java.util.logging.Logger;

// https://urvanov.ru/2019/07/03/%D0%BB%D0%BE%D0%B3%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%81-jul-java-util-logging/
public class JulLogger {
    public static final Logger logger = Logger.getLogger(JulLogger.class.getName());

    public static void main(String[] args) {
        // WTF
        logger.log(Level.INFO, "Application started and constructed.");
        logger.info("Application started and constructed.");

//        try {
//            Files.readAllBytes(Paths.get("/file/does/not/exist"));
//        } catch (IOException ioex) {
//            logger.log(Level.SEVERE, "Error message", ioex);
//        }


        // https://www.vogella.com/tutorials/Logging/article.html - with implements formatters
    }
}
