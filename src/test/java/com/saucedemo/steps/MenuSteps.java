package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.MenuPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.DriverManager;
import com.saucedemo.utils.TestDataUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import java.util.Map;

public class MenuSteps {

    private WebDriver driver;
    private MenuPage menuPage;
    private DriverManager driverManager;

    @Given("the user is logged in and on the products page")
    public void the_user_is_logged_in_and_on_the_products_page() {
        driverManager = new DriverManager();
        driver = driverManager.initializeDriver();
        driver.get("https://www.saucedemo.com/");
        Map<String, String> credentials = TestDataUtil.getCredentials("standard_user");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(credentials.get("username"), credentials.get("password"));
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductListDisplayed());
        menuPage = new MenuPage(driver);
    }

    @When("the user opens the burger menu")
    public void the_user_opens_the_burger_menu() {
        menuPage.openMenu();
    }

    @Then("the user should see the logout button")
    public void the_user_should_see_the_logout_button() {
        Assert.assertTrue(menuPage.isLogoutButtonDisplayed());
        driverManager.quitDriver();
    }

    @When("the user clicks the logout button")
    public void the_user_clicks_the_logout_button() {
        menuPage.logout();
    }

    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        Assert.assertTrue(menuPage.isLoginPageDisplayed());
        driverManager.quitDriver();
    }
}
