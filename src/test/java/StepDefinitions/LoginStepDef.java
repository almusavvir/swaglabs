package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pageObjects.LoginPage;
import utilities.AlertHandler;

import java.io.File;
import java.io.IOException;
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
        options.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080");

        driver=new ChromeDriver();
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
    public void clicks_on_login_button() throws InterruptedException {
        Thread.sleep(3000);
        lp.clickLoginButton();
    }

    @Then("User should be landed on the homepage")
    public void user_should_be_landed_on_the_homepage() throws InterruptedException {

        //handles chrome's password found in breach (change password) alert
        //AlertHandler.dismissAlertIfExists(driver);
        //asserts true if the logout link is visible / displayed in the hamburger menu
        Thread.sleep(1000);
        //Assert.assertEquals(lp.checkLogoutButtonVisible(), true);
    }

    @Then("User takes screenshot of the page")
    public void userTakesScreenshotOfThePage() {
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

    @Then("User closes the browser")
    public void userClosesTheBrowser() {
        driver.quit();
    }

    @When("User enters invalid username and password")
    public void userEntersInvalidUsernameAndPassword() {
        lp.enterUserName("standard_user");
        lp.enterPassword("12345");
    }

    @Then("User should get incorrect password error")
    public void userShouldGetIncorrectPasswordError() {

    }

//    @When("User enters invalid username and password")
//    public void userEntersInvalidUsernameAndPassword() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
}
