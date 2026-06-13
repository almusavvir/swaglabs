package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.*;
import utilities.BaseClass;

public class CheckoutStepDefs extends BaseClass {

    @And("User selects product and adds to cart")
    public void userSelectsProductAndAddsToCart() {
        hp.clickBackPackItem();
        pp.addProductToCart();
    }

    @And("User opens cart and verifies added item <{string}> in cart")
    public void userOpensCartAndVerifiesAddedItemInCart(String product) {

    }

    @And("User clicks on checkout")
    public void userClicksOnCheckout() {
        pp.clickOnCartButton();
        cp.clickCheckoutButton();
    }

    @And("User enters buyer information and clicks on continue")
    public void userEntersBuyerInformationAndClicksOnContinue() {
        chkp.enterBuyerDetails();
        chkp.clickContinueCheckoutButton();
    }

    @And("User clicks on finish button")
    public void userClicksOnFinishButton() {
        chkp.clickFinishButton();
    }

    @Then("User should get the order confirmation message")
    public void userShouldGetTheOrderConfirmationMessage() {

        System.out.println(driver.getCurrentUrl());
        try {
            Assert.assertTrue(chkp.verifyOrderComplete("Thank you for your order!"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
