package com.othWayToGetDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Properties;

public class ClassicWebDriver {
    private static WebDriver webDriver;

    private ClassicWebDriver() {
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            File file = new File("src/test/resources/chromedriver.exe");
            Properties properties = System.getProperties();
            properties.put("webdriver.chrome.driver", file.getAbsolutePath());
            System.setProperties(properties);
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }


}
