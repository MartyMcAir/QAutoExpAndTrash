package com.instance;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

abstract class DrvManager_DesiredCapability {
    private static WebDriver webDriver;
    private static WebDriverWait webDriverWait;
    private static RemoteWebDriver remoteWebDriver;
    private static JavascriptExecutor javascriptExecutor;
    private static Actions actions;

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--incognito");
//            options.addArguments("--headless", "--window-size=1920,1080");
//            options.addArguments("--start-maximize");
//            options.setProxy(new Proxy());

//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//            webDriver = new ChromeDriver(capabilities);

//            System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
            webDriver = new ChromeDriver(options);
        }
        return webDriver;
    }

    public static WebDriverWait getWebDriverWait() {
        return webDriverWait == null ? webDriverWait = new WebDriverWait(getWebDriver(), 10) : webDriverWait;
    }

    public static void enableImplicitlyWait() {
        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static RemoteWebDriver getRemoteWebDriver() {
        if (remoteWebDriver == null) {
            // https://www.lambdatest.com/blog/desired-capabilities-in-selenium-testing/
            DesiredCapabilities capabilities = new DesiredCapabilities();
            // FOR JAVA
            capabilities.setBrowserName("BrowserChrome");
            capabilities.setVersion("95.0");
            capabilities.setPlatform(Platform.WIN10);
            // OR
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("version", "95.0");
            // If this cap isn't specified, it will just get any available one
            capabilities.setCapability("platformVersion", "win10");
            capabilities.setCapability("build", "LambdaTestSampleApp");
            capabilities.setCapability("name", "LambdaTestJavaSample");
            capabilities.setCapability("network", true); // To enable network logs
            capabilities.setCapability("visual", true); // To enable step by step screenshot
            capabilities.setCapability("video", true); // To enable video recording
            capabilities.setCapability("console", true); // To capture console logs

            capabilities.setCapability("selenium_version", "4.0.0-alpha-2");
            capabilities.setCapability("timezone", "UTC+05:30");
            capabilities.setCapability("geoLocation", "IN");
            capabilities.setCapability("chrome.driver", "78.0");

            // For Appium or Android..
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "10.0");
            capabilities.setCapability("deviceName", "Samsung Galaxy Note10");

            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("app", "path for the app under test");

            try {
                remoteWebDriver = new RemoteWebDriver(new URL(""), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return remoteWebDriver;
    }

    public static JavascriptExecutor getJavascriptExecutor() {
        return javascriptExecutor == null ? javascriptExecutor = (JavascriptExecutor) getWebDriver() : javascriptExecutor;
    }

    public static Actions getActions() {
        return actions == null ? actions = new Actions(getWebDriver()) : actions;
    }
}
