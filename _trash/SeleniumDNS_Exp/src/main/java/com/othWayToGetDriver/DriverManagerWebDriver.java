package com.othWayToGetDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManagerWebDriver {
    private static WebDriver webDriver;
    private static WebDriverWait webDriverWait;
    private WebDriverWait webDriverWaitNotStatic;
    private static Actions actions;
    private static JavascriptExecutor javaScriptExecutor;
    private static FluentWait<WebDriver> fluentWait;

    private DriverManagerWebDriver() {
    }

    public DriverManagerWebDriver(String someText) {
        System.out.println(someText);
        webDriverWaitNotStatic = new WebDriverWait(getWebDriver(), 10);
    }

    public WebDriverWait getWebDriverWaitNotStatic() {
        System.out.println("it invoke only if used because it not static");
        return webDriverWaitNotStatic;
    }

    public static FluentWait<WebDriver> getFluentWait() {
        if (fluentWait == null) {
            fluentWait = new FluentWait<>(getWebDriver());
        }
        return fluentWait;
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            WebDriverManager.chromedriver().setup();

//            System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--disable-notifications");
            opt.addArguments("--incognito");

//            opt.addArguments("--start-fullscreen");
//            opt.addArguments("--start-maximized");

//            opt.addArguments("--headless", "--window-size=1920,1080");
//            opt.setProxy(new Proxy());
            webDriver = new ChromeDriver(opt);
            // FOR HeadLess Mode
            // FOR Proxy
//            Proxy proxy = new Proxy();
//            proxy.setHttpProxy("myhttpproxy:3337");
//            opt.setProxy(proxy);
        }
        return webDriver;
    }


    public static WebDriverWait getWebDriverWait() {
        if (webDriverWait == null) {
//             WebDriverWait наследуется от FluentWait (Fluent - реализует until() method..)
            System.out.println("getWebDriverWait - it invoke always _ even if method dnt used");
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

    public static JavascriptExecutor getJavascriptExecutor() {
        if (javaScriptExecutor == null) {
            // Обычный new ChromeDriver драйвер, наследуется от RemoteWebDriver
            // - и он реализует интерфейс JavascriptExecutor
            javaScriptExecutor = (JavascriptExecutor) getWebDriver();
        }
        return javaScriptExecutor;
    }
}
