package com.saucedemo.steps;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.DriverManager;
import com.saucedemo.pages.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class CartSteps {

    private WebDriver driver;
    private CartPage cartPage;
    private DriverManager driverManager;

    @Given("the user has added a product to the cart")
    public void the_user_has_added_a_product_to_the_cart() {
        driverManager = new DriverManager();
        driver = driverManager.initializeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.goToCart();
        cartPage = new CartPage(driver);
    }

    @When("the user goes to the cart")
    public void the_user_goes_to_the_cart() {
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
    }

    @Then("the user should be able to proceed to checkout")
    public void the_user_should_be_able_to_proceed_to_checkout() {
        cartPage.goToCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.isFirstNameInputDisplayed());
        driverManager.quitDriver();
    }
}
