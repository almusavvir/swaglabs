package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHandler {

    //handles any alert but primarily created for handling Chrome's "password found in breach" alert

        public static void dismissAlertIfExists(WebDriver driver) {
            try {
//                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
//                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                Thread.sleep(2000);
                driver.switchTo().alert().dismiss();
                System.out.println("Alert was present and was dismissed");
            }
            catch (NoAlertPresentException e) {
                System.out.println("No alert present -> continuing");
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            catch (TimeoutException e) {
                System.out.println("No alert present (timeout) -> continuing");
            }
        }
}