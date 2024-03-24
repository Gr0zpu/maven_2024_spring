package com.saucedemo.pages;

import com.saucedemo.core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class ChktStepOnePage extends BaseSeleniumPage {
    @FindBy(id = "first-name")
    private WebElement fNameArea;
    @FindBy(id = "last-name")
    private WebElement lNameArea;
    @FindBy(id = "postal-code")
    private WebElement zipArea;
    @FindBy(id = "continue")
    private WebElement folowStepTwo;


    public ChktStepOnePage() {
        PageFactory.initElements(driver, this);
    }


    public ChktStepTwoPage folowStepTwo(String firstName, String lastName, String zip){
        fNameArea.sendKeys(firstName);
        lNameArea.sendKeys(lastName);
        zipArea.sendKeys(zip);
        folowStepTwo.click();
        return new ChktStepTwoPage();
    }

}
