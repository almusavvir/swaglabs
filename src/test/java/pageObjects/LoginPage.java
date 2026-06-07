package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    //locators

    @FindBy(id="user-name")
    WebElement userNameTextBox;

    @FindBy(id="password")
    WebElement passwordTextBox;

    @FindBy(id="login-button")
    WebElement loginButton;

    //methods

    public void enterUserName() {
        userNameTextBox.click();
        userNameTextBox.sendKeys("standard_user");
    }

    public void enterPassword() {
        passwordTextBox.click();
        passwordTextBox.clear();
        passwordTextBox.sendKeys("secret_sauce");
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
