package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.DriverManager;
import com.saucedemo.pages.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class ProductsSteps {

    private WebDriver driver;
    private ProductsPage productsPage;
    private DriverManager driverManager;

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        driverManager = new DriverManager();
        driver = driverManager.initializeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductListDisplayed());
    }

    @When("the user adds the first product to the cart")
    public void the_user_adds_the_first_product_to_the_cart() {
        productsPage.addFirstProductToCart();
    }

    @Then("the cart should contain one item")
    public void the_cart_should_contain_one_item() {
        productsPage.goToCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
        driverManager.quitDriver();
    }
}
