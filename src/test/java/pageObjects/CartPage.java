package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    //locators

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    @CacheLookup
    WebElement cartProductName;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    @CacheLookup
    WebElement productPrice;

    @FindBy(xpath = "//button[@id='checkout']")
    @CacheLookup
    WebElement checkoutButton;

    //methods

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public String getProductName(){
        return cartProductName.getText();
    }

    public String getProductPrice(){
        return productPrice.getText();
    }
}
