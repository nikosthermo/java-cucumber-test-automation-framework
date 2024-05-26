package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(id = "checkout_complete_container")
    private WebElement checkoutComplete;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
        continueButton.click();
    }

    public boolean isFirstNameInputDisplayed() {
        return firstNameInput.isDisplayed();
    }

    public boolean isFinishButtonDisplayed() {
        return finishButton.isDisplayed();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public boolean isCheckoutCompleteDisplayed() {
        return checkoutComplete.isDisplayed();
    }
}
