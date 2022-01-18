package com.instance;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Level;

abstract class DrvManager_DesiredCapability {
    private static WebDriver webDriver;
    private static WebDriverWait webDriverWait;
    private static RemoteWebDriver remoteWebDriver;
    private static JavascriptExecutor javascriptExecutor;
    private static Actions actions;
    private static FluentWait<WebDriver> fluentWait;

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

    public static FluentWait<WebDriver> getFluentWait() {
        // https://www.browserstack.com/guide/wait-commands-in-selenium-webdriver
        // https://www.softwaretestingmaterial.com/selenium-fluentwait/
        if (fluentWait == null) {
            fluentWait = new FluentWait<>(getWebDriver());   //Declare and initialise a fluent wait
        }
        return fluentWait;
    }

    public static FluentWait<WebDriver> getFluentWait_shortExample() {
        // https://www.techbeamers.com/webdriver-fluent-wait-command-examples/
        if (fluentWait == null) {
            FluentWait<WebDriver> fluentWait = new FluentWait<>(getWebDriver())
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

    public static RemoteWebDriver getRemoteWebDriver_liteExample() {
        if (remoteWebDriver == null) {
            try {
                // FOR JAVA
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName("BrowserChrome");
                cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
                cap.setVersion("95.0");
                cap.setPlatform(Platform.ANDROID);
                cap.setCapability("automationName", "Appium");
                cap.setCapability("deviceName", "Samsung Galaxy Note10");
                cap.setCapability("selenium_version", "4.0.0-alpha-2");
                LoggingPreferences logs = new LoggingPreferences();
                logs.enable(LogType.SERVER, Level.FINE);
                logs.enable(LogType.CLIENT, Level.SEVERE);
                logs.enable(LogType.BROWSER, Level.FINER);
                cap.setCapability(CapabilityType.LOGGING_PREFS, logs);
                RemoteWebDriver remoteDriver = new RemoteWebDriver(new URL(""), cap);

                // Logging Setting ALL OFF WARNING CONFIG
//                cap.setCapability("platformName", "Android");
//                cap.setCapability("platformVersion", "10.0");
//                logs.enable(LogType.DRIVER, Level.FINEST);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return remoteWebDriver;
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
