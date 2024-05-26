package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    @FindBy(className = "inventory_list")
    private WebElement productList;

    @FindBy(css = ".inventory_item:first-child .btn_inventory")
    private WebElement firstProductAddToCartButton;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addFirstProductToCart() {
        firstProductAddToCartButton.click();
    }

    public void goToCart() {
        cartButton.click();
    }

    public boolean isProductListDisplayed() {
        return productList.isDisplayed();
    }
}
