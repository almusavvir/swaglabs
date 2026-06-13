package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ChekcoutPage extends BasePage {

    public ChekcoutPage(WebDriver driver) {
        super(driver);
    }

    //locators

    @FindBy(id = "first-name")
    WebElement txtFirstName;

    @FindBy(id = "last-name")
    WebElement txtLastName;

    @FindBy(id = "postal-code")
    WebElement txtPostalCode;

    @FindBy(id = "continue")
    WebElement continueCheckoutButton;

    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishButton;

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement orderCompleteHeader;


    //methods

    public void enterBuyerDetails(){
        txtFirstName.sendKeys("John");
        txtLastName.sendKeys("Doe");
        txtPostalCode.sendKeys("12345");
    }

    public void clickContinueCheckoutButton() {
        continueCheckoutButton.click();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public boolean verifyOrderComplete(String orderConfirmationMessage){
        return orderCompleteHeader.getText().equals(orderConfirmationMessage);
    }

    public String getVerifyOrderCompleteMessage(){
        return orderCompleteHeader.getText();
    }

}
