package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountActivityPage extends BasePage {



    @FindBy(id = "aa_accountId")
    public WebElement dropDown;

    @FindBy(xpath = "//option[@value='6']")
    public WebElement dropDownBrokerage;

    @FindBy(xpath = "//a[contains(text(),'Find Transactions')]")
    public WebElement findTransaction;



}
