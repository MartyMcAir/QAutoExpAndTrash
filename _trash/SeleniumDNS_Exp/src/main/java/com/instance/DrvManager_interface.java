package com.instance;

import com.utils.SingleForInterface;
import com.utils.StatCounter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public interface DrvManager_interface {
    WebDriver webDriver = getWebDriver();
    WebDriverWait webDriverWait = getWebDriverWait();
    RemoteWebDriver remoteWebDriver = getRemoteWebDriver();
    JavascriptExecutor javascriptExecutor = getJavaScriptExecutor();
    Actions actions = getActions();
    StatCounter statCounter = getStatCounter();
    StatCounter alwaysNewStatCounter = getAlwaysNewStatCounter();
    SingleForInterface singleForInterface = new SingleForInterface();

    private static WebDriver getWebDriver() {
        WebDriver webDrv = webDriver;
        if (webDrv == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--incognito");
//            options.addArguments("--headless", "--window-size=1920,1080");
//            options.addArguments("--start-maximized");

//            System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
            webDrv = new ChromeDriver(options);
            System.out.println(StatCounter.increment());
        }
        System.out.println("getWebDriver");
        return webDrv;
    }

    // MalformedURLException !!!
    private static RemoteWebDriver getRemoteWebDriver() {
        RemoteWebDriver remoteDrv = remoteWebDriver;
        if (remoteDrv == null) {
            try {
                // https://coderoad.ru/17527951/%D0%9A%D0%B0%D0%BA%D0%B0%D1%8F-%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%B0-%D0%BE%D1%82-DesiredCapabilities-%D0%B2-Selenium-WebDriver
                DesiredCapabilities capabilities = new DesiredCapabilities();
                remoteDrv = new RemoteWebDriver(new URL(""), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("getRemoteWebDriver");
        return remoteDrv;
    }

    private static WebDriverWait getWebDriverWait() {
        System.out.println("getWebDriverWait");
        return webDriverWait == null ? new WebDriverWait(webDriver, 10) : webDriverWait;
    }

    private static Actions getActions() {
        System.out.println("getActions");
        return actions == null ? new Actions(webDriver) : actions;
    }

    private static JavascriptExecutor getJavaScriptExecutor() {
        System.out.println("getJavaScriptExecutor");
        return javascriptExecutor == null ? (JavascriptExecutor) webDriver : javascriptExecutor;
    }

    private static StatCounter getStatCounter() {
        System.out.println("getStatCounter");
        return statCounter == null ? new StatCounter() : statCounter;
    }

    private static StatCounter getAlwaysNewStatCounter() {
        System.out.println("getAlwaysNewStatCounter");
        return new StatCounter();
    }
}
