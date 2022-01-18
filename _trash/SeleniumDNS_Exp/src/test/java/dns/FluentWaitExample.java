package dns;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitExample extends DnsBaseClass {
    public static void main(String[] args) {
        //Specify the timout of the wait
//            fluentWait.withTimeout(5000, TimeUnit.MILLISECONDS);
        fluentWait.withTimeout(Duration.ofSeconds(10));
        //Sepcify polling time
//            fluentWait.pollingEvery(250, TimeUnit.MILLISECONDS);
        fluentWait.pollingEvery(Duration.ofSeconds(10));
        //Specify what exceptions to ignore
        fluentWait.ignoring(NoSuchElementException.class);

        //This is how we specify the condition to wait on.
        //This is what we will explore more in this chapter
        Alert alert = fluentWait.until(ExpectedConditions.alertIsPresent());
        WebElement webElement = fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

        //.............................................................................
        Function<WebDriver, WebElement> function = new Function<>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return null;
            }
        };
        WebElement webElement1 = fluentWait.until(function);

        //.............................................................................
        Function<WebDriver, WebElement> function2 = new Function<>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("foo"));
            }
        };
        WebElement webElement2 = fluentWait.until(function2);
    }
}
