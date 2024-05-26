package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void openMenu() {
        menuButton.click();
    }

    public void logout() {
        logoutButton.click();
    }

    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }

    public boolean isLoginPageDisplayed() {
        return driver.getCurrentUrl().contains("https://www.saucedemo.com/");
    }
}
