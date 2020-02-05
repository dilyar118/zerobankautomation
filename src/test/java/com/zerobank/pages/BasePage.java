package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {



    @FindBy(id = "searchTerm")
    public WebElement searchInput;

    @FindBy(className = "brand")
    public WebElement pageSubTitle;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement settings;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[2]")
    public WebElement username;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li")
    public List<WebElement> menuOptions;

    @FindBy(xpath = "//li[normalize-space()='Account Activity' and contains(@id, 'account_activity_tab')]")
    public WebElement accountActivity;

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=1']")
    public WebElement saving1;

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=3']")
    public WebElement saving2;

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=6']")
    public WebElement brokerage;

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=2']")
    public WebElement cheking;

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=5']")
    public WebElement creditCard;

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=4']")
    public WebElement loan;




    @FindBy(id = "logout_link")
    public WebElement logOut;



    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }


    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(username);
        BrowserUtils.clickWithJS(logOut);
    }

    public void navigateToModule(String tab) {
        String tabLocator = "//a[contains(text(),'" + tab + "')]";

        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
    }




}
