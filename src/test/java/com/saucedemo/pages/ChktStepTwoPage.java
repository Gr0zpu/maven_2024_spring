package com.saucedemo.pages;

import com.saucedemo.core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChktStepTwoPage extends BaseSeleniumPage {
    @FindBy(id = "finish")
    private WebElement finishBtn;

    @FindBy(id = "cancel")
    private WebElement canceBtn;

    @FindBy(className = "summary_subtotal_label")
    private WebElement checkOutTotal;
    public ChktStepTwoPage() {

        PageFactory.initElements(driver, this);
    }

    public ChktComplete folowComplete(){
        finishBtn.click();
        return new ChktComplete();
    }

    public Double getTotal(){

        return Double.parseDouble(checkOutTotal.getText().trim().substring(13));
    }


}
