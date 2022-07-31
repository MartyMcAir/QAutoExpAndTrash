package com.othWayToGetDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class ClassicWebDriver {

    private static WebDriver webdriver;
    private static RemoteWebDriver remoteWebDriver;
    private static WebDriverWait webDriverWait;
    private static Actions actions;
    private static JavascriptExecutor javascriptExecutor;

    private static FluentWait<WebDriver> fluentWait;
    private static TakesScreenshot takesScreenshot;

    public static WebDriver getWebdriver() {
        if (webdriver == null) {
//            System.setProperty("webdriver.chrome.driver", "pathsToDriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito", "--disable-notifications");
//            options.addArguments("--headless", "--start-maximized", "--window-size=1920,1080");
//            options.setProxy(new Proxy());

            WebDriverManager.chromedriver().setup();
            webdriver = new ChromeDriver(options);
        }
        return webdriver;
    }

    public static TakesScreenshot getTakesScreenshot(String pathToFile) {
        if (takesScreenshot == null) {
            TakesScreenshot take = (TakesScreenshot) getWebdriver();
            File screenshot = take.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File(pathToFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return takesScreenshot;
    }

    public static FluentWait<WebDriver> getFluentWait() {
        // https://www.browserstack.com/guide/wait-commands-in-selenium-webdriver
        // https://www.softwaretestingmaterial.com/selenium-fluentwait/
        if (fluentWait == null) {
            fluentWait = new FluentWait<>(getWebdriver());   //Declare and initialise a fluent wait
        }
        return fluentWait;
    }

    public static FluentWait<WebDriver> getFluentWait_shortExample() {
        // https://www.techbeamers.com/webdriver-fluent-wait-command-examples/
        if (fluentWait == null) {
            FluentWait<WebDriver> fluentWait = new FluentWait<>(getWebdriver())
                    .withTimeout(Duration.ofSeconds(15)) // повтор проверки
                    .pollingEvery(Duration.ofSeconds(5)) // услов не выполнено = ждать 5 сек
                    .ignoring(NoSuchElementException.class);

//            Function<WebDriver, WebElement> function = new Function<>() {
//                public WebElement apply(WebDriver driver) {
//                    return driver.findElement(By.id("foo"));
//                }
//            };
//            fluentWait.until(function);
        }
        return fluentWait;
    }

    public static RemoteWebDriver getRemoteWebDriver() {
        if (remoteWebDriver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "11");
            capabilities.setCapability("deviceName", "Pixel_3a");
            capabilities.setCapability("udid", "5554-p");

            capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
            capabilities.setCapability("version", "95");

            LoggingPreferences logs = new LoggingPreferences();
            logs.enable(LogType.SERVER, Level.FINE);
            capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
            try {
                remoteWebDriver = new RemoteWebDriver(new URL(""), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return remoteWebDriver;
    }

    public static WebDriverWait getWebDriverWait() {
        if (webDriverWait == null) {
//            webDriverWait = new WebDriverWait(getWebdriver(), Duration.ofSeconds(30));
            webDriverWait = new WebDriverWait(getWebdriver(), 30);
        }
        return webDriverWait;
    }

    public static Actions getActions() {
        if (actions == null) {
            actions = new Actions(getWebdriver());
        }
        return actions;
    }

    public static void onImplicitlyWait() {
//        getWebdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        getWebdriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static JavascriptExecutor getJavascriptExecutor() {
        if (javascriptExecutor == null) {
            javascriptExecutor = (JavascriptExecutor) getWebdriver();
        }
        return javascriptExecutor;
    }

}
