package StepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import utilities.SSUtil;

import java.io.File;
import java.io.IOException;

public class UtilityStepDefs extends LoginStepDefs {
    @Then("User takes screenshot of the page")
    public void userTakesScreenshotOfThePage() {
        SSUtil.takeScreenShot(driver);
    }
}
