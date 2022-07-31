package experimentals;

import com.instance.DrvManager;
import org.openqa.selenium.WebDriver;

public class Experimental_abstract {
    private static final WebDriver webDriver = DrvManager.getWebDriver();

    public static void main(String[] args) {
        webDriver.navigate().to("https://dns-shop.ru");
        webDriver.navigate().to("https://google.com");
        webDriver.navigate().to("https://mail.ru");
        webDriver.navigate().to("https://dns-shop.ru");


        waitForTime(6);
        webDriver.quit();
    }

    private static void waitForTime(long seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
