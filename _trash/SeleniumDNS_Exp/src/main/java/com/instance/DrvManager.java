package com.instance;

//import com.utils.StatCounter;
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
import java.util.concurrent.atomic.AtomicInteger;

public abstract class DrvManager {
    private static final AtomicInteger atom = new AtomicInteger();
    private static WebDriver webDriver;
    private static WebDriverWait webDriverWait;
    private static RemoteWebDriver remoteWebDriver;
    private static JavascriptExecutor javascriptExecutor;
    private static Actions actions;
//    private static StatCounter statCounter;

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--incognito");
//            options.addArguments("--headless", "--window-size=1920,1080");
//            options.addArguments("--start-maximized");
//            options.setProxy(new Proxy());

//            System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
            webDriver = new ChromeDriver(options);
//            System.out.println("___________ getWebDriver INNER: ");
        }
//        System.out.println("getWebDriver #: " + atom.getAndIncrement());
        return webDriver;
    }

    public static void enableImplicitlyWait() {
        System.out.println("enableImplicitlyWait");
        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriverWait getWebDriverWait() {
        System.out.println("getWebDriverWait - it invoke always _ even if method dnt used");
        return webDriverWait == null ? webDriverWait = new WebDriverWait(getWebDriver(), 10) : webDriverWait;
    }

    public static RemoteWebDriver getRemoteWebDriver() {
        if (remoteWebDriver == null) {
            try {
//                DesiredCapabilities.chrome();
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setPlatform(Platform.ANDROID);
                capabilities.setVersion("4");
                capabilities.setBrowserName("Chrome");
                capabilities.setCapability("Windows 10", Platform.WINDOWS);
                capabilities.setCapability("BrowserName", "version");
                remoteWebDriver = new RemoteWebDriver(new URL(""), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("getRemoteWebDriver");
        return remoteWebDriver;
    }

    public static JavascriptExecutor getJavascriptExecutor() {
//        System.out.println("getJavascriptExecutor");
        return javascriptExecutor == null ? javascriptExecutor = (JavascriptExecutor) getWebDriver() : javascriptExecutor;
    }

    public static Actions getActions() {
//        System.out.println("getActions");
        return actions == null ? actions = new Actions(getWebDriver()) : actions;
    }

//    public static StatCounter getStatCounter() {
//        return statCounter == null ? statCounter = new StatCounter() : statCounter;
//    }
//
//    public static StatCounter getAlwaysNewInstance_statCounter() {
//        return new StatCounter();
//    }
}
