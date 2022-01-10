package dns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class DnsClickMonitorAndChooseFilters extends DnsBaseClass {
    @Test
    void navigateTest() {
        moveToLeftBar();
        monitorClick();
        selectFilters();

        waitForDomByJS();
        String currentUrl = webDriver.getCurrentUrl();
        System.out.println(currentUrl);
        webDriver.navigate().to(currentUrl);
        waitForDomByJS();


//        By xpath = By.xpath("a[class='catalog-product__name ui-link ui-link_black']"); // don't work
        By xpath = By.xpath("//div[@data-id='product']"); // work
//        By cssSelector = By.cssSelector("a[class~='catalog-product__name']");
        List<WebElement> elements = webDriver.findElements(xpath);

        for (WebElement current : elements) {
//            WebElement elements1 = current.findElement(By.xpath("//a[@class='catalog-product__name ui-link ui-link_black'"));
//            String href = elements1.getAttribute("href");
//            System.out.println(current.getText());

            String a = current.findElement(By.cssSelector("a")).getText();
            System.out.println(a);
        }
    }

    private void selectFilters() {
        waitForDomByJS();
        javaScriptExecutor.executeScript("window.scrollTo(0, 3300)"); // need scroll!

        String xpathToWideDisplay = "//div[@class='left-filters__list']//span[contains(text(), 'Соотношение')]"; // good
//        String xpathToWideDisplay = "//div[@class='ui-list-controls ui-collapse ui-collapse_list'][9]"; // good
        moveToElementAndClick_byXpath(xpathToWideDisplay);

//div[@class='ui-list-controls ui-collapse ui-collapse_list'][10]//span[contains(text(), '16:9')]

//        findElementByXpath_andClick(xpathToWideDisplay); // don't work
//        WebElement wideDisplay = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathToWideDisplay)));
//        wideDisplay.click(); // error
//        actions.moveToElement(wideDisplay).click().perform(); // need move before click!

        moveToElementAndClick_byXpath("//span[contains(text(), '21:9')]");
        moveToElementAndClick_byXpath("//span[contains(text(), '32:9')]");
        moveToElementAndClick_byXpath("//button[contains(text(), 'Применить')]");

        // OR
//        javaScriptExecutor.executeScript("window.scrollTo(0, 3500)"); // need scroll!
//        By wide_21_9 = By.xpath("//span[contains(text(), '21:9')]");
//        WebElement element_21_9 = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(wide_21_9));
//        actions.moveToElement(element_21_9).click().perform();
    }

    private void moveToLeftBar() {
        By locator = By.cssSelector("a[href='/catalog/17aa72ab16404e77/komplektuyushhie-kompyutery-i-noutbuki/']");
        WebElement el = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(el).perform();
    }

    private void monitorClick() {
        By pathToMonitorLink = By.cssSelector("a[href='/catalog/17a8943716404e77/monitory/']");
        WebElement monitorElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(pathToMonitorLink));
        monitorElement.click();
    }

}
