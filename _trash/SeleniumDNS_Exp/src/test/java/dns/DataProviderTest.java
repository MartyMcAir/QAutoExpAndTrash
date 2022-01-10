package dns;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest extends DnsBaseClass {

    @DataProvider(name = "myProviderName")
    Object[][] myProvider() {
        return new Object[][]{
                new Object[]{"https://google.com"},
                new Object[]{"https://www.dns-shop.ru/?fa821dba_ipp_key=v1639308409624%2Fv3394bd400b5e53a13cfc65163aeca6afa04ab3%2Fr2aUW2VED6m8pAoa7XFrhQ%3d%3d&fa821dba_ipp_uid=1639308409624%2fJjWZSHVniqc9IAMA%2f%2bSK5ay8vlP1GaRhOFPM9cg%3d%3d"},
                // OR
//                {"https://google.com/"}, // 1 second
//                {"https://www.dns-shop.ru/"}, // 5 seconds
        };
    }

    @Test(dataProvider = "myProviderName")
    void someLinks(String url) {
//        WebElement body = webDriver.findElement(By.tagName("body"));
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

//        javaScriptExecutor.executeScript(String.format("document.location.href = \"%1$s\";", url));
        javaScriptExecutor.executeScript(String.format("setTimeout(function(){ window.location.href = \"%1$s\"; }, 5 * 1000);", url));
    }
}
