package dns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DnsClickMonitor extends DnsBaseClass {

    @Test
    void openDnsPage() {
        By xpath = By.xpath("//div[@class='menu-desktop']//div[@class='menu-desktop__root'][4]");

        WebElement element = webDriver.findElement(xpath);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        actions.moveToElement(element).build().perform();

        By monitors = By.xpath("//a[text()='Мониторы']");
        By xpath3 = By.xpath("//div[@class='menu-desktop__submenu menu-desktop__submenu_top']");
//        By xpath2 = By.xpath("//div[@class='menu-desktop__second-level-wrap']/a[@class='ui-link menu-desktop__second-level'][0]");
//        WebElement element1 = webDriver.findElement(xpath3);
//        System.out.println("element1.isEnabled(): " + element1.isEnabled());
//        System.out.println("element1.isDisplayed(): " + element1.isDisplayed());
//        System.out.println("element1.isSelected(): " + element1.isSelected());

//        webDriverWait.until(ExpectedConditions.visibilityOf(element1));
//        actions.moveToElement(element1).contextClick(element1).build().perform();

        WebElement element1 = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(monitors));
        element1.click();

    }

    @Test
    void someTest() {
        System.out.println("fffffff");
    }
}
