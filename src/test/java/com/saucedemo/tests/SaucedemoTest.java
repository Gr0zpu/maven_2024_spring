package com.saucedemo.tests;

import com.saucedemo.pages.*;
import com.saucedemo.core.BaseSeleniumTest;
import com.saucedemo.core.ConfigProvider;
import helpers.TestValues;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaucedemoTest extends BaseSeleniumTest {


    @Test
    public void checkSum(){
        ChktStepTwoPage chktStepTwoPage = new LoginPage().login(ConfigProvider.STANDARD_USER_LOGIN, ConfigProvider.STANDARD_USER_PASSWORD)
                .addAllItems()
                .folowCart()
                .folowCheckout()
                .folowStepTwo(TestValues.FIRSTNAME, TestValues.LASTNAME, TestValues.ZIP);

        Assert.assertEquals(chktStepTwoPage.getTotal(), TestValues.TOTAL);
    }

    @Test
    public void checkCheckout(){
        String login = ConfigProvider.STANDARD_USER_LOGIN;
        String password = ConfigProvider.STANDARD_USER_PASSWORD;
        LoginPage loginPage = new LoginPage();
        ChktComplete chktComplete = loginPage.login(login,password)
                .addRandomItems()
                .folowCart()
                .folowCheckout()
                .folowStepTwo(TestValues.FIRSTNAME, TestValues.LASTNAME, TestValues.ZIP)
                .folowComplete();

        Assert.assertEquals(chktComplete.getCompleteMessage(), TestValues.SUCUCCESSFULCHECKOUT);
    }



    @Test
    public void logOut() throws InterruptedException {


        LoginPage loginPage = new LoginPage().login(ConfigProvider.STANDARD_USER_LOGIN, ConfigProvider.STANDARD_USER_PASSWORD).logout();
        Assert.assertEquals(loginPage.getLoginLogo(), ConfigProvider.LOGIN_PAGE_ID);
    }


    @Test
    public void login(){
        //InventoryPage inventoryPage = new LoginPage().login(ConfigProvider.STANDARD_USER_LOGIN, ConfigProvider.STANDARD_USER_PASSWORD);
        InventoryPage inventoryPage = new LoginPage().login(ConfigProvider.STANDARD_USER_LOGIN, ConfigProvider.STANDARD_USER_PASSWORD);
        Assert.assertEquals(inventoryPage.getInventoryId(), ConfigProvider.INVENTORY_PAGE_ID);
    }

    @Test
    public void cartItems(){
        CartPage cartPage = new LoginPage().login(ConfigProvider.STANDARD_USER_LOGIN, ConfigProvider.STANDARD_USER_PASSWORD).addRandomItems().folowCart();
        Assert.assertTrue(!cartPage.getCartItems().isEmpty());

    }

    @Test
    public void cartCounter(){
        InventoryPage inventoryPage = new LoginPage().login(ConfigProvider.STANDARD_USER_LOGIN, ConfigProvider.STANDARD_USER_PASSWORD).addRandomItems();
        Assert.assertTrue(!inventoryPage.getCartCount().isEmpty());
    }





}
