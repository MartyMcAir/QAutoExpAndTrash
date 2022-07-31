package com.singleton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum EnumSingleTonDriver {
    INSTANCE;

    private static WebDriver webDriver;

    public static WebDriver getWebDriver(EnumBrowsers browserName) {
        if (webDriver == null) createDriver(browserName);
        return webDriver;
    }

    private static void createDriver(EnumBrowsers browserName) {
//        switch (browserName) {
//            case CHROME -> {
//                WebDriverManager.chromedriver().setup();
//                webDriver = new ChromeDriver(InitOptions.defChromeOpt(false));
//            }
//            case FIREFOX -> {
//                WebDriverManager.firefoxdriver().setup();
//                webDriver = new FirefoxDriver(InitOptions.defFirefoxOptions());
//            }
//            default -> throw new NullPointerException("WebDriver not instantiated");
//        }
    }
}
