package examples;

import com.instance.DrvManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ScreenShotsNotion {
    private static final WebDriver webDriver = DrvManager.getWebDriver();
    private static final WebDriverWait webDriverWait = DrvManager.getWebDriverWait();
    private static final Actions actions = DrvManager.getActions();
    private static final JavascriptExecutor javaScriptExecutor = DrvManager.getJavascriptExecutor();

    public static void main(String[] args) throws IOException {
        webDriver.navigate().to("https://www.notion.so/alfamobile/1d58f91fd87946aabffd734bb35cd404");

        int i = 0;
        while (true) {
            userConsole();

            Path folderPath = Paths.get("./src/test/resources/img").toAbsolutePath();
            Path fileName = Paths.get(webDriver.getTitle().replaceFirst("/", "_").replace("?", "_") + (i++) + ".png");
            Path pathForNewScreenShot = folderPath.resolve(fileName);

            TakesScreenshot take = (TakesScreenshot) webDriver;
            File screenshot = take.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(pathForNewScreenShot.toString()));

        }
    }

    public static void userConsole() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Чтобы продолжить введите 0: ");
            if (in.hasNextInt()) {
                int x = in.nextInt();
                if (x == 0) break;
                if (in.hasNextLine()) in.nextLine();
            }
        }
    }

}
