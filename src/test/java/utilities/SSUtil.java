package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class SSUtil {

    public static void takeScreenShot(WebDriver driver) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
            String fileName = "screenshot_" + timestamp + ".png";
            File targetFile = new File("./screenshots/" + fileName);
            FileHandler.copy(srcFile, targetFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
