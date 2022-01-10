package com.othWayToGetDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManagerWebDriver {
    private static WebDriver webDriver;
    private static WebDriverWait webDriverWait;
    private static Actions actions;
    private static JavascriptExecutor javaScriptExecutor;

    private DriverManagerWebDriver() {
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
//            System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--incognito");
//            options.addArguments("--start-maximized");
            // FOR HeadLess Mode
//            options.addArguments("--headless", "--window-size=1920,1080");
            // FOR Proxy
//            Proxy proxy = new Proxy();
//            proxy.setHttpProxy("myhttpproxy:3337");
//            options.setProxy(proxy);
            webDriver = new ChromeDriver(options);
        }
        return webDriver;
    }

    public static WebDriverWait getWebDriverWait() {
        if (webDriverWait == null) {
            // WebDriverWait наследуется от FluentWait (Fluent - реализует until() method..)
            webDriverWait = new WebDriverWait(getWebDriver(), 10);
        }
        return webDriverWait;
    }

    public static void enabledImplicitlyWait(int seconds) {
        getWebDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static Actions getActions() {
        if (actions == null) {
            actions = new Actions(getWebDriver());
        }
        return actions;
    }

    public static JavascriptExecutor getJavaScriptExecutor() {
        if (javaScriptExecutor == null) {
            // Обычный new ChromeDriver драйвер, наследуется от RemoteWebDriver
            // - и он реализует интерфейс JavascriptExecutor
            javaScriptExecutor = (JavascriptExecutor) getWebDriver();
        }
        return javaScriptExecutor;
    }
}
