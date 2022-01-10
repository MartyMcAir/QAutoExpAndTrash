package com.singleton;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


public final class InitOptions {
    private static final ChromeOptions optChrome = new ChromeOptions();
    private static final FirefoxOptions optFirefox = new FirefoxOptions();

    protected static ChromeOptions defChromeOpt(boolean headlessMode) {

        optChrome.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (headlessMode) {
            optChrome.addArguments("--headless");
            optChrome.addArguments("--window-size=1920,1080");
            optChrome.addArguments("--no-sandbox");
            optChrome.addArguments("--disable-gpu");
            optChrome.addArguments("--incognito");
            optChrome.addArguments("--disable-popup-blocking");
            optChrome.addArguments("--disable-extensions");
            optChrome.addArguments("--disable-infobars");
            optChrome.addArguments("--verbose");
            optChrome.addArguments("--verbose");
            optChrome.addArguments("--disable-dev-shm-usage");
        }
        optChrome.addArguments("--start-maximized");
        optChrome.addArguments("--no-sandbox");
        optChrome.addArguments("--disable-gpu");
        optChrome.addArguments("--incognito");
        optChrome.addArguments("--disable-popup-blocking");
        optChrome.addArguments("--disable-extensions");
        optChrome.addArguments("--disable-infobars");
        return optChrome;
    }

    protected static FirefoxOptions defFirefoxOptions() {
        optFirefox.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        optFirefox.addPreference("browser.private.browsing.autostart", true);

        return optFirefox;
    }

}
