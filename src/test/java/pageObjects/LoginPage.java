package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {
    WebDriver driver;

    //constructor

    public LoginPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //locators

    @FindBy(id="user-name")
    WebElement userNameTextBox;

    @FindBy(id="password")
    WebElement passwordTextBox;

    @FindBy(id="login-button")
    WebElement loginButton;

    @FindBy(id="react-burger-menu-btn")
    WebElement hamburgerMenuButton;

    @FindBy(xpath="//a[@id='logout_sidebar_link']")
    WebElement logoutLink;

    @FindBy(xpath="//a[@class='bm-item menu-item']")
    List<WebElement> menuList;

    @FindBy(xpath = "//h3[contains(text(),'Epic sadface: Username and password do not match')]")
    WebElement errorLabel;

    //methods
    // later need to change username and password to string input from
    // feature files
    public void enterUserName(String username) {
        userNameTextBox.click();
        userNameTextBox.sendKeys(username);

    }

    public void enterPassword(String password) {
        passwordTextBox.click();
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean checkLogoutButtonVisible() {
        try {
            hamburgerMenuButton.click();
            Thread.sleep(3000);
            return logoutLink.isDisplayed();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkErrorButtonVisible() {
        try {
            Thread.sleep(1000);
            return errorLabel.isDisplayed();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
