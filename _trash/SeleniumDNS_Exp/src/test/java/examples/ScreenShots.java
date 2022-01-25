package examples;

import com.othWayToGetDriver.DriverManagerWebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShots {
    private static final WebDriver webDriver = DriverManagerWebDriver.getWebDriver();
    private static final WebDriverWait webDriverWait = DriverManagerWebDriver.getWebDriverWait();
    private static final Actions actions = DriverManagerWebDriver.getActions();
    private static final JavascriptExecutor javaScriptExecutor = DriverManagerWebDriver.getJavascriptExecutor();

    public static void main(String[] args) throws IOException {
//        notStaticUse();
        webDriver.navigate().to("https://www.google.com/");
        WebElement searchInput = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name='q']")));


        Path folderPath = Paths.get("./src/test/resources/img").toAbsolutePath();
        Path fileName = Paths.get("file.png");
        Path pathForNewScreenShot = folderPath.resolve(fileName);
//        System.out.println(pathForNewScreenShot);

        TakesScreenshot take = (TakesScreenshot) webDriver;
        File screenshot = take.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(pathForNewScreenShot.toString()));

        // to Google Pictures
        webDriver.navigate().to("https://www.google.ru/imghp?hl=ru");
        WebElement picBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("*[jscontroller='vCzgHd']")));
        picBtn.click();

        WebElement upLoadBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Загрузить изображение']")));
        upLoadBtn.click();

        WebElement inputFile = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
        inputFile.sendKeys(pathForNewScreenShot.toAbsolutePath().toString());

    }

    private static void notStaticUse() {
        DriverManagerWebDriver driverInstance = new DriverManagerWebDriver("hello from obj");
//        WebDriverWait webDriverWaitNotStatic = driverInstance.getWebDriverWaitNotStatic();
    }

}
