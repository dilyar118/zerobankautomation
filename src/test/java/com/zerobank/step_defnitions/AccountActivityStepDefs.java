package com.zerobank.step_defnitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.DashBoardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepDefs {

    DashBoardPage dashBoardPage = new DashBoardPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();


    @Given("the user is logged in")
    public void the_user_is_logged_in() {

        LoginPage loginPage = new LoginPage();
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginPage.login(username,password);
    }

    @When("the user clicks on Savings link on the Account Summary PAGE")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_PAGE() {

        dashBoardPage.saving1.click();
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {

        Assert.assertTrue(dashBoardPage.accountActivity.isEnabled());

    }

    @Then("Account drop down should have Saving selected")
    public void account_drop_down_should_have_Saving_selected() {


        Select select =  new Select(accountActivityPage.dropDown);
        Assert.assertEquals("Savings", select.getFirstSelectedOption().getText());
    }

    @When("the user clicks on Brokerage link on the Account Summary PAGE")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_PAGE() {

        dashBoardPage.brokerage.click();

    }

    @Then("Account drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
      Select select = new Select(accountActivityPage.dropDown);
      Assert.assertEquals("Brokerage", select.getFirstSelectedOption().getText());
    }

    @When("the user clicks on Cheking link on the Account summary page")
    public void the_user_clicks_on_Cheking_link_on_the_Account_summary_page() {
        dashBoardPage.cheking.click();
    }

    @Then("Account drop down should have Cheking selected")
    public void account_drop_down_should_have_Cheking_selected() {
        Select select = new Select(accountActivityPage.dropDown);
        Assert.assertEquals("Checking", select.getFirstSelectedOption().getText());
    }

    @When("the user clicks on Credit Card link on the Account Summary Page")
    public void the_user_clicks_on_Credit_Card_link_on_the_Account_Summary_Page() {
        dashBoardPage.creditCard.click();
    }

    @Then("Account drop down should have Credit Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        Select select = new Select(accountActivityPage.dropDown);
        Assert.assertEquals("Credit Card", select.getFirstSelectedOption().getText());
    }

    @When("the user click on Loan link on the Account Summary page")
    public void the_user_click_on_Loan_link_on_the_Account_Summary_page() {
        dashBoardPage.loan.click();
    }

    @Then("Account drop down should have Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        Select select = new Select(accountActivityPage.dropDown);
        Assert.assertEquals("Loan", select.getFirstSelectedOption().getText());
    }

}
