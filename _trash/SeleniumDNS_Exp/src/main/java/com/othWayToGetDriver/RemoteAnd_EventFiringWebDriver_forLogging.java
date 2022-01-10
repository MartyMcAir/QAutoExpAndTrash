package com.othWayToGetDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class RemoteAnd_EventFiringWebDriver_forLogging {
    private static WebDriver remoteWebDriver;
    private static EventFiringWebDriver eventFiringWebDriver;

    public static EventFiringWebDriver getEventFiringWebDriver_forLogging() {
        if (eventFiringWebDriver == null) {
            eventFiringWebDriver = new EventFiringWebDriver(DriverManagerWebDriver.getWebDriver());
            eventFiringWebDriver.register(new CustomLoggingListener());
        }
        return eventFiringWebDriver;
    }

    public static WebDriver getRemoteWebDriver() {
        if (remoteWebDriver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            // For Remote Driver
            options.setCapability("browserVersion", "67");
            options.setCapability("platform", "Windows XP");
            try {
                remoteWebDriver = new RemoteWebDriver(new URL("https://example.com"), options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return remoteWebDriver;
    }

    public static WebDriver desiredCapabilitiesForLogging_Example1() {
        // Бывают ситуации, когда логгирование необходимо полностью отключить,
        // или сделать минимальным количество сообщений.
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.CLIENT, Level.SEVERE);
        logs.enable(LogType.DRIVER, Level.WARNING);
        logs.enable(LogType.PERFORMANCE, Level.INFO);
        logs.enable(LogType.SERVER, Level.ALL);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
        return new ChromeDriver(capabilities);
    }

    public static WebDriver desiredCapabilitiesForRemoteDriver_Example2() {
        RemoteWebDriver remoteWebDriver = null;
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(""), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return remoteWebDriver;
    }

    public static WebDriver desiredCapabilitiesForApioum_Example3() {
        RemoteWebDriver remoteWebDriver = null;
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", "your Device Name");
        // Set BROWSER_NAME desired capability.
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        // Set android VERSION desired capability. Set your mobile device's OS version.
        capabilities.setCapability(CapabilityType.VERSION, "5.1");
        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");
        // Set android appPackage desired capability.
        //You нужно проверить ваше имя appPackage для вашего приложения, вы можете использовать это приложение для этой ИНФОРМАЦИИ APK
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appPackage", "com.android.appPackageName");
        // Set android appActivity desired capability. You can use the same app for finding appActivity of your app
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        try {
            remoteWebDriver = new RemoteWebDriver(new URL(""), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return remoteWebDriver;
    }
}
