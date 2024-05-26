package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class AuthenticationSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private DriverManager driverManager;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driverManager = new DriverManager();
        driver = driverManager.initializeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("the user should be redirected to the products page")
    public void the_user_should_be_redirected_to_the_products_page() {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductListDisplayed());
        driverManager.quitDriver();
    }
}
