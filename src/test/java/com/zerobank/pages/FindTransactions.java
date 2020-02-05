package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindTransactions  extends  BasePage{


    @FindBy(xpath = "//input[@id='aa_fromDate']")
    public WebElement dateRangeFrom;

    @FindBy(xpath = "//input[@id='aa_toDate']")
    public WebElement dateRangeTo;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findButton;

    @FindBy(id = "aa_description")
    public WebElement description;

    public void enterDates(String startingDate, String endingDate){
        dateRangeFrom.sendKeys(startingDate);
        dateRangeTo.sendKeys(endingDate);

    }


}
