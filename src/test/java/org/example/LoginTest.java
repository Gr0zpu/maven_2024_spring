package org.example;

import com.saucedemo.core.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class LoginTest {

    protected WebDriver driver = new ChromeDriver();
    protected FluentWait wait = new FluentWait<>(driver);


    @Test
    public void loginLogoutTest() throws InterruptedException {

        this.driver.get("https://www.saucedemo.com");

        WebElement userName = this.driver.findElement(By.name("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = this.driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        WebElement btnLogin = this.driver.findElement(By.name("login-button"));
        btnLogin.click();

        WebElement burgerMenu = this.driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();

        Thread.sleep(250);

        WebElement btnLogOut = this.driver.findElement(By.id("logout_sidebar_link"));
        btnLogOut.click();

    }


    @Test

    public void readConfig(){
        String  urlFromConf = ConfigProvider.STANDARD_USER_PASSWORD;
        System.out.println(urlFromConf);
    }
}
