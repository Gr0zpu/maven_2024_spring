package com.saucedemo.pages;

import com.saucedemo.core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChktComplete extends BaseSeleniumPage {
    @FindBy(className = "complete-header")
    private WebElement completeMessage;

    public ChktComplete() {
        PageFactory.initElements(driver, this);
    }

    public String getCompleteMessage(){

        return completeMessage.getText();
    }
}
