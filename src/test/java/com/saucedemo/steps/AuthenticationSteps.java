package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.DriverManager;
import com.saucedemo.utils.TestDataUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import java.util.Map;

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

    @When("the user logs in as {string}")
    public void the_user_logs_in_as_string(String userType) {
        Map<String, String> credentials = TestDataUtil.getCredentials(userType);
        loginPage.login(credentials.get("username"), credentials.get("password"));
    }

    @Then("the user should be redirected to the products page")
    public void the_user_should_be_redirected_to_the_products_page() {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductListDisplayed());
        driverManager.quitDriver();
    }
}
