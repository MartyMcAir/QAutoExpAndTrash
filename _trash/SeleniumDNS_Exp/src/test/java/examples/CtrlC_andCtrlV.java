package examples;

import com.instance.DrvManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CtrlC_andCtrlV {
    private static final WebDriver webDriver = DrvManager.getWebDriver();
    private static final WebDriverWait webDriverWait = DrvManager.getWebDriverWait();
    private static final Actions actions = DrvManager.getActions();
    private static final JavascriptExecutor javaScriptExecutor = DrvManager.getJavascriptExecutor();

    public static void main(String[] args) {
        webDriver.navigate().to("https://www.google.com/");
        WebElement searchInput = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name='q']")));

        searchInput.sendKeys("bio engineering");

        String copy = Keys.chord(Keys.CONTROL, "c");
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        String cut = Keys.chord(Keys.CONTROL, "x");
        String paste = Keys.chord(Keys.CONTROL, "v"); // also it working if user copy from OS

        searchInput.sendKeys(selectAll);
//        searchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        searchInput.sendKeys(cut);

        searchInput.sendKeys(" future is ");
        searchInput.sendKeys(paste);


    }

}
