package com.saucedemo.pages;

import com.saucedemo.core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationMenu extends BaseSeleniumPage {
    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement menuLogOut;

    @FindBy(id = "reset_sidebar_link")
    private WebElement menuReset;

    @FindBy(id = "react-burger-cross-btn")
    private WebElement menuClose;


    public NavigationMenu() {
        PageFactory.initElements(driver, this);
    }

    public void menuReset(){
        menuReset.click();
    }


    public void menuClose(){
        menuClose.click();
    }
    public void openMenu(){
        burgerMenu.click();
    }

    public void logOut(){
        menuLogOut.click();
    }
}
