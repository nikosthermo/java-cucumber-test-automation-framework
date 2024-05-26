package com.saucedemo.steps;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class CheckoutSteps {

    private WebDriver driver;
    private CheckoutPage checkoutPage;
    private DriverManager driverManager;

    @Given("the user is on the checkout page")
    public void the_user_is_on_the_checkout_page() {
        driverManager = new DriverManager();
        driver = driverManager.initializeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.goToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCheckout();
        checkoutPage = new CheckoutPage(driver);
    }

    @When("the user enters checkout information {string}, {string}, {string}")
    public void the_user_enters_checkout_information(String firstName, String lastName, String postalCode) {
        checkoutPage.enterCheckoutInformation(firstName, lastName, postalCode);
    }

    @Then("the user should be able to continue to the next step")
    public void the_user_should_be_able_to_continue_to_the_next_step() {
        // Assuming the next step has some identifiable element
        Assert.assertTrue(checkoutPage.isContinueButtonDisplayed());
        driverManager.quitDriver();
    }
}
