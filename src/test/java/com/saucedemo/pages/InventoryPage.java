package com.saucedemo.pages;

import com.saucedemo.core.BaseSeleniumPage;
import helpers.RandomList;
import helpers.TestValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;
import java.util.Set;

public class InventoryPage extends BaseSeleniumPage {

    private NavigationMenu navigationMenu;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartLink;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemsList;

    @FindBy(xpath = "//*[contains(text(), 'Add to cart')]")
    private List<WebElement> addAllToCart;

    @FindBy(xpath =  "//div[@class='inventory_item']")
    private List<WebElement> items;

    @FindBy(xpath = "//div[@class='pricebar']")
    private List<WebElement> priceAndBtn;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement inventoryId;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cartCount;

    public String getCartCount() {
        return cartCount.getText();
    }

    public String getInventoryId() {
        return inventoryId.getText();
    }

    public InventoryPage() {
        navigationMenu = new NavigationMenu();

        PageFactory.initElements(driver, this);
    }

    public LoginPage logout(){
        navigationMenu.openMenu();
        navigationMenu.logOut();
        return new LoginPage();
    }

    public InventoryPage resetState(){
        navigationMenu.openMenu();
        navigationMenu.menuReset();
        navigationMenu.menuClose();

        return this;
    }

    public CartPage folowCart(){
        cartLink.click();
        return new CartPage();
    }

    public ItemPage folowItem(){
        itemsList.get(0).click();
        return new ItemPage();
    }

    public InventoryPage addAlltoCart(){
        for (WebElement addToCart: addAllToCart){
            addToCart.click();
        }
        return this;
    }

    public InventoryPage addRandomItems(){
        Set<WebElement> set = RandomList.arr(addAllToCart);
        for (WebElement element : set){
            element.click();
        }
        return this;
    }

    public InventoryPage addAllItems(){
            TestValues.TOTAL = 0.0;
        for (WebElement element : items){
            element.findElement(By.xpath("//*[contains(text(), 'Add to cart')]")).click();

            TestValues.TOTAL += Double
                       .parseDouble(element.findElement(By.xpath(".//div[@class='inventory_item_price']")).getText().trim().substring(1));

        }


        return this;
    }
}
