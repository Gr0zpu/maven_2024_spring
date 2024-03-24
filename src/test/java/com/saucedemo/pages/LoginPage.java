package com.saucedemo.pages;

import com.saucedemo.core.BaseSeleniumPage;
import com.saucedemo.core.ConfigProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumPage {
//    private final By enterLogin = By.name("user-name");
//    private final By enterPassword = By.name("password");

    @FindBy (name = "user-name")
    private WebElement enterLogin;
    @FindBy(name = "password")
    private WebElement enterPassword;
    @FindBy(name = "login-button")
    private WebElement btnLogin;

    @FindBy(className = "login_logo")
    private WebElement loginLogo;

    public LoginPage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public InventoryPage login(String loginValue, String passwordValue){
        enterLogin.sendKeys(loginValue);
        enterPassword.sendKeys(passwordValue);
        btnLogin.click();
        return new InventoryPage();
    }

    public InventoryPage inventoryPage(){
        return new InventoryPage();
    }

    public String getLoginLogo() {
        return loginLogo.getText();
    }
}
