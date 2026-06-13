package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BaseClass {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //locators

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    @CacheLookup
    WebElement productTitle;

    @FindBy(xpath = "//button[@id='remove']")
    @CacheLookup
    WebElement removeItemFromCartButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    @CacheLookup
    WebElement cartButton;



    //methods

    public boolean verifyProductTitle(String product) {
        return productTitle.getText().equals(product);
    }

    public void clickOnRemoveItemFromCartButton(){
        removeItemFromCartButton.click();
    }

    public void clickOnCartButton(){
        cartButton.click();
    }
}
