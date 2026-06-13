package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public static WebDriver driver;
    public static HomePage hp;
    public static ProductPage pp;
    public static CartPage cp;
    public static ChekcoutPage chkp;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
