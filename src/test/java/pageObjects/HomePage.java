package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //locators

    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Backpack']")
    @CacheLookup
    WebElement backPack;

    //methods

    public void clickBackPackItem(){
        backPack.click();
    }
}
