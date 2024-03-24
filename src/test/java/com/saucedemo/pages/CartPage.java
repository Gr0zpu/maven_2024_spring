package com.saucedemo.pages;

import com.saucedemo.core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseSeleniumPage {
    @FindBy(id = "checkout")
    private WebElement folowCheckout;

    @FindBy(id = "continue-shopping")
    private WebElement backShoping;

    @FindBy(xpath = "//div[@class='cart_item']")
    private List<WebElement> cartItems;

    public List<WebElement> getCartItems() {
        return cartItems;
    }

    public CartPage() {

        PageFactory.initElements(driver, this);
    }


    public InventoryPage backShoping(){
        backShoping.click();
        return new InventoryPage();
    }

    public ChktStepOnePage folowCheckout(){
        folowCheckout.click();
        return new ChktStepOnePage();
    }

}
