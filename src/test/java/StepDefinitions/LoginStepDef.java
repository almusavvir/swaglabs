package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pageObjects.LoginPage;
import utilities.AlertHandler;

import java.util.HashMap;
import java.util.Map;

public class LoginStepDef {

    public WebDriver driver;
    public LoginPage lp;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://saucedemo.com");
        lp=new LoginPage(driver);
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        lp.enterUserName("standard_user");
        lp.enterPassword("secret_sauce");
    }

    @And("Clicks on login button")
    public void clicks_on_login_button() {
        lp.clickLoginButton();
    }

    @Then("User should be landed on the homepage")
    public void user_should_be_landed_on_the_homepage() throws InterruptedException {

        //handles chrome's password found in breach (change password) alert
        //AlertHandler.dismissAlertIfExists(driver);
        //asserts true if the logout link is visible / displayed in the hamburger menu
        Thread.sleep(1000);
        Assert.assertEquals(lp.checkLogoutButtonVisible(), true);

        //closing driver here for now
        driver.close();
    }

//    @When("User enters invalid username and password")
//    public void userEntersInvalidUsernameAndPassword() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
}
