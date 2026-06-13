package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.*;
import utilities.BaseClass;

public class Hooks extends BaseClass {
    @Before
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--disable-gpu", "--window-size=1920, 1080");

        driver = new ChromeDriver(options);

        lp   = new LoginPage(driver);
        hp   = new HomePage(driver);
        pp   = new ProductPage(driver);
        cp   = new CartPage(driver);
        chkp = new ChekcoutPage(driver);
    }

    @After
    public void tearDown() {
        if(driver!=null){
            driver.quit();
        }
    }
}
