package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

//    @FindBy(xpath="//button[@id='react-burger-menu-btn']")
//    WebElement hamburgerMenuButton;

    @FindBy(id="react-burger-menu-btn")
    WebElement hamburgerMenuButton;

    @FindBy(id="logout-sidebar-link")
    WebElement logoutLink;

    @FindBy(xpath="//a[@class='bm-item menu-item']")
    List<WebElement> menuList;

    //methods
    // later need to change username and password to string input from
    // feature files
    public void enterUserName(String username) {
        userNameTextBox.click();
        userNameTextBox.sendKeys(username);

//        driver.findElement(By.id("user-name"))
//                .sendKeys("standard_user");
    }

    public void enterPassword(String password) {
        passwordTextBox.click();
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public void clickLoginButton() {
        //loginButton.click();
        menuList.get(2).click();
    }

    public boolean checkLogoutButtonVisible() {
        hamburgerMenuButton.click();
        return logoutLink.isDisplayed();
    }

}
