package experimentals;

import com.instance.DrvManager;
import com.utils.TimerUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DNS_openPage {
    private static final WebDriver webDriver = DrvManager.getWebDriver();
    private static final WebDriverWait webDriverWait = DrvManager.getWebDriverWait();
    private static final Actions actions = DrvManager.getActions();
    private static final JavascriptExecutor javaScriptExecutor = DrvManager.getJavascriptExecutor();

    public static void main(String[] args) {
        webDriver.navigate().to("https://www.dns-shop.ru/?fa821dba_ipp_key=v1639506291341%2Fv3394bd400b5e53a13cfc65163aeca6afa04ab3%2FXh19yoPHbQA2C%2b%2fa%2b0szJA%3d%3d&fa821dba_ipp_uid=1639506291341%2f5ETvJsDmqGCpjT68%2fsUkWztlJ8x2rXtwgaik%2bhA%3d%3d");
        TimerUtils timerUtils = new TimerUtils();
        timerUtils.startTimer();

        goToMonitorsPage();

        String hvStr = "//div[contains(@class, 'products-page__left-block')]//div[@class='left-filters__list']//a//span[text()='Соотношение сторон']";
        By horizontalVerticalMenuPath = By.xpath(hvStr);

//        javaScriptExecutor.executeScript("window.scrollTo(0, 3300)"); //Scroll vertically down by 3300 pixels

        waitForDomByJS();
        javaScriptExecutor.executeScript("window.scrollBy(0, 3300)"); //Scroll vertically down by 3300 pixels
//        javaScriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement hvElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(horizontalVerticalMenuPath));
        hvElement.click();

        By wide21_9Path = By.xpath("//div[contains(@class, 'products-page__left-block')]//div[@class='left-filters__list']//div[contains(@class, 'ui-collapse__content')]//span[contains(text(), '21:9')]");
        By wide32_9Path = By.xpath("//div[contains(@class, 'products-page__left-block')]//div[@class='left-filters__list']//div[contains(@class, 'ui-collapse__content')]//span[contains(text(), '32:9')]");

        timerUtils.getAndShowCountedTime();

//        waitForTime(3);
//        webDriver.quit();
    }

    public static void waitForDomByJS() {
        while (!domElementsIsComplete()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean domElementsIsComplete() { // Ожидание загрузки DOM дерева
        System.out.println("wait");
        // loading interactive complete
        System.out.println(javaScriptExecutor.executeScript("return document.readyState"));
        return javaScriptExecutor.executeScript("return document.readyState").equals("complete");
    }

    private static void goToMonitorsPage() {
        By cityPath = By.cssSelector("div[class='dropdown-city']>a[class~='btn-additional']");
        By widgetPath = By.cssSelector("div[class~=\"info-widget\"]>span[class~=\"info-widget__close\"]");
        By pcLinkPath = By.xpath("//div[@class='menu-desktop']//div[@class='menu-desktop__root']//a[text()='Компьютеры']");
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(cityPath));
        WebElement widgetElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(widgetPath));
        WebElement pcElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(pcLinkPath));

//        webElement.click();
//        widgetElement.click();
//        actions.moveToElement(pcElement).perform();

//        Action build = actions.moveToElement(webElement).pause(10).click().contextClick(webElement)
//                .clickAndHold().doubleClick().release().dragAndDrop(webElement, pcElement).build();
//        build.perform();
//        actions.click(webElement).click(widgetElement).moveToElement(pcElement).perform();
        actions.click(webElement).pause(500).click(widgetElement).pause(500).moveToElement(pcElement).pause(500).perform();

        By monitorLinkPath = By.xpath("//div[contains(@class, 'menu-desktop__submenu')]//div[@class='menu-desktop__second-level-wrap']//a[text()='Мониторы']");
        WebElement monitorElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(monitorLinkPath));
        monitorElement.click();
    }

    private static void checkCurrentInstance() {
        System.out.println("before: " + webDriver.getTitle());
        webDriver.navigate().to(webDriver.getCurrentUrl());
        System.out.println(webDriver.getTitle());
    }

    private static void waitForTime(long seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
