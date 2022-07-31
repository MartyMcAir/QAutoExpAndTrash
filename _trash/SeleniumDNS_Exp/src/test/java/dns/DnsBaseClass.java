package dns;

import com.othWayToGetDriver.DriverManagerWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

abstract class DnsBaseClass {
    WebDriver webDriver = DriverManagerWebDriver.getWebDriver();
    WebDriverWait webDriverWait = DriverManagerWebDriver.getWebDriverWait();
    Actions actions = DriverManagerWebDriver.getActions();
    // using JS, can't get WebElement or text from _ what find..
    JavascriptExecutor javaScriptExecutor = DriverManagerWebDriver.getJavascriptExecutor();
    static FluentWait<WebDriver> fluentWait = DriverManagerWebDriver.getFluentWait();

    @BeforeClass
    void setUp() {
        String link = "https://www.dns-shop.ru/?fa821dba_ipp_key=v1639308409624%2Fv3394bd400b5e53a13cfc65163aeca6afa04ab3%2Fr2aUW2VED6m8pAoa7XFrhQ%3d%3d&fa821dba_ipp_uid=1639308409624%2fJjWZSHVniqc9IAMA%2f%2bSK5ay8vlP1GaRhOFPM9cg%3d%3d";
        javaScriptExecutor.executeScript(String.format("document.location.href = \"%14s\"", link));

        waitForDomByJS();
        acceptDropDownCity();
        closeWidget();

// don't work
//        javaScriptExecutor.executeScript("arguments[0].scrollIntoView();", webDriver.findElement(By.xpath("..")));
//        javaScriptExecutor.executeScript("window.scrollBy(0, 3300)"); //Scroll vertically down by 3300 pixels
        //        javaScriptExecutor.executeScript("window.scrollTo(0, 3300)"); //Scroll vertically down by 3300 pixels
    }

    //    @AfterClass
    void tearDown() {
        webDriver.quit();
    }

    void acceptDropDownCity() {
//        findElementByXpath_andClick("//div[@class='dropdown-city']/a[@class='btn btn-additional']");
//        findElementByCss_andClick("div[class='dropdown-city']>a[class='btn btn-additional']");
        findElementByWhat_andClick("getElementsByClassName", "btn btn-additional");
    }

    void closeWidget() {   // To find a hidden element in selenium using JavaScriptExecutor
        By path = By.cssSelector("div[class~='info-widget']>span[class='info-widget__close']");
        WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(path));
        javaScriptExecutor.executeScript("arguments[0].click();", element);
    }

    void acceptDropDown2() {
        By droDownCity = By.cssSelector("div[class=dropdown-city]>a[class~=btn-additional]");
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(droDownCity));
        element.click();
    }

    void closeWidget2() {
        By fullPathToCloseBtn = By.cssSelector("div[class='info-widget info-widget_warning info-widget__little info-widget_clamp']>span");
        By shortPathToCloseBtn = By.cssSelector("div[class~=info-widget]>span");
        By shortXpath = By.xpath("//div[contains(@class, 'info-widget')]/span");

        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(shortPathToCloseBtn));
        element.click();
    }

    void moveToElementAndClick_byXpath(String byXpath) {
        waitForDomByJS();
        moveToElementIntoView_byXpath(byXpath);
        waitForDomByJS();
        findElementByXpath_andClick(byXpath);
    }

    void waitForDomByJS() {
        while (!domElementsIsComplete()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // .................................................................................................................

    void moveToElementIntoView_byCssSelector(String cssSelector) {
        String jsCode = String.format("document.querySelector(\"%1$s\").scrollIntoView()", cssSelector);
        javaScriptExecutor.executeScript(jsCode);
    }

    void moveToElementIntoView_byXpath(String byXpath) {
        String jsCode = String.format("function getElementByXpath(path) { " +
                "  return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue" +
                "} " + "getElementByXpath(\"%1$s\").scrollIntoView()", byXpath);
        javaScriptExecutor.executeScript(jsCode);
    }

    // .................................................................................................................

    boolean domElementsIsComplete() { // Ожидание загрузки DOM дерева
        System.out.println("wait");
        // loading interactive complete
        System.out.println(javaScriptExecutor.executeScript("return document.readyState"));
        return javaScriptExecutor.executeScript("return document.readyState").equals("complete");
    }

    void findElementByXpath_andClick(String byXpath) {
        String jsCode = String.format("function getElementByXpath(path) { " +
                "  return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue" +
                "} " + "getElementByXpath(\"%1$s\").click()", byXpath);
        javaScriptExecutor.executeScript(jsCode);
    }

    void findElementByCss_andClick(String css) {
        //  getElementById // getElementsByClassName
        // getElementsByTagName // getElementsByName
        String jsCode = String.format("document.querySelector(\"%1$s\").click()", css);
        javaScriptExecutor.executeScript(jsCode);
        javaScriptExecutor.executeScript("document.querySelector(\"#idName\").click()");
        javaScriptExecutor.executeAsyncScript("asynchronous script here");
    }

    void findElementByWhat_andClick(String byWhat, String value) {
        //  getElementById // getElementsByClassName
        // getElementsByTagName // getElementsByName
        String jsCode = String.format("document.%1$s(\"%2$s\")[0].click()", byWhat, value);
        javaScriptExecutor.executeScript(jsCode);
    }
}
