package com.saucedemo.pages;

import com.saucedemo.core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends BaseSeleniumPage {
    @FindBy(id = "back-to-products")
    private WebElement backToInventory;

    @FindBy(name = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCart;

    @FindBy(name = "remove-sauce-labs-backpack")
    private WebElement removeFromCart;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartLink;

    public ItemPage() {
        PageFactory.initElements(driver, this);
    }

    public InventoryPage backToInventory(){
        backToInventory.click();
        return new InventoryPage();
    }

    public ItemPage addToCart(){
            addToCart.click();
        return this;
    }

    public ItemPage removeFromCart(){
        removeFromCart.click();
        return this;

    }


}
