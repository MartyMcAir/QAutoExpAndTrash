package experimentals;

import com.instance.DrvManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SelenMethodsAndExceptions {
    WebDriverWait webDriverWait = DrvManager.getWebDriverWait();
    WebDriver webDriver = DrvManager.getWebDriver();
    Actions actions = DrvManager.getActions();

    @Test(threadPoolSize = 6, invocationCount = 10, timeOut = 1000)
    void opeTest() {
        String str = null;

        webDriver.navigate().to("http://10.10.15.38:90/");

        Alert until = webDriverWait.until(ExpectedConditions.alertIsPresent());
        WebElement until2 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        Boolean until1 = webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("")));
        WebElement until3 = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
        WebElement until4 = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
        Boolean until7 = webDriverWait.until(ExpectedConditions.elementToBeSelected(By.xpath("")));
        Boolean until6 = webDriverWait.until(ExpectedConditions.textToBe(By.xpath(""), ""));
        Boolean until5 = webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(""), ""));

        // paste it to the field
//        element.sendKeys(Keys.CONTROL, "v");

// • NoSuchElementException _ NoSuchFrameException  _ NoSuchWindowException
// • TimeoutException
// • ElementNotVisibleException
// • NoAlertPresentException - при попытке передать управление диалоговому окну, которого в данный момент нет
// • UnhandledAlertException  - Возникает при появлении неожиданных модальных диалоговых окон.


    }

}
