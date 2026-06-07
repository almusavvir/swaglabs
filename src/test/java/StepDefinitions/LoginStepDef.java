package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

public class LoginStepDef {

    WebDriver driver = new ChromeDriver();
    LoginPage lp = new LoginPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {

        lp.enterUserName();
        lp.enterPassword();

        throw new io.cucumber.java.PendingException();
    }

    @And("Clicks on login button")
    public void clicks_on_login_button() {

        lp.clickLoginButton();

        throw new io.cucumber.java.PendingException();
    }

    @Then("User should be landed on the homepage")
    public void user_should_be_landed_on_the_homepage() {

        throw new io.cucumber.java.PendingException();
    }

}
