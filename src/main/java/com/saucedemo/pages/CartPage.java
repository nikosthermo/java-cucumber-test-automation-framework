package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void goToCheckout() {
        checkoutButton.click();
    }

    public boolean isCheckoutButtonDisplayed() {
        return checkoutButton.isDisplayed();
    }
}
