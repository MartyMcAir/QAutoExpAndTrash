package com.othWayToGetDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class CustomLoggingListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

        super.beforeFindBy(by, element, driver);
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        System.out.println("ALERT NOT ACCEPT");
        super.afterAlertDismiss(driver);
    }
}
