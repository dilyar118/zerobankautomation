package com.zerobank.step_defnitions;

        import com.zerobank.pages.AccountActivityPage;
        import com.zerobank.pages.DashBoardPage;
        import com.zerobank.pages.FindTransactions;
        import com.zerobank.utilities.BrowserUtils;
        import com.zerobank.utilities.Driver;
        import io.cucumber.java.en.But;
        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import org.junit.Assert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import java.util.*;

public class FindTransactionsStepDefs {


    DashBoardPage dashBoardPage = new DashBoardPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    FindTransactions findTransactions = new FindTransactions();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {

        dashBoardPage.navigateToModule("Account Activity");
        BrowserUtils.waitFor(1);
        accountActivityPage.findTransaction.click();
        BrowserUtils.waitFor(2);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String startDate, String endDate) {


        findTransactions.enterDates(startDate,endDate);
        BrowserUtils.waitFor(2);
        findTransactions.dateRangeFrom.clear();
        BrowserUtils.waitFor(2);
        findTransactions.dateRangeTo.clear();


    }

    @When("clicks search")
    public void clicks_search() {
        findTransactions.findButton.click();
        BrowserUtils.waitFor(3);

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String startDate, String endDate) {
        String startdate1 = startDate.replace("-", "");
        int startdate = Integer.parseInt(startdate1);
        System.out.println(startdate);

        String enddate2 = endDate.replace("-","");
        int enddate = Integer.parseInt(enddate2);
        System.out.println(enddate);

        List<WebElement> dates = Driver.get().findElements(By.xpath("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[1]"));
        for(WebElement eachDate : dates){
            System.out.println(eachDate.getText());

            String textDate = eachDate.getText().replace("-","");
            System.out.println(textDate);
            int resultDates = Integer.parseInt(textDate);
            if(resultDates >= startdate && resultDates <= enddate){
                System.out.println(true);
            }
        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<WebElement> dates = Driver.get().findElements(By.xpath("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[1]"));
        List<String> originalDates = new ArrayList<>();
        for(WebElement date : dates) {
            originalDates.add(date.getText().replace("-",""));
        }

        List<String> actualDates = originalDates;
        Collections.reverse(actualDates);
        Assert.assertEquals(actualDates,originalDates);

        System.out.println("Original dates " + originalDates);
        System.out.println("Temperary sorted Dates " + actualDates);


    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String startDate) {
        List<WebElement> dates = Driver.get().findElements(By.xpath("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[1]"));
        for(WebElement date : dates){
            if(!(date.getText().contains(startDate))){
                System.out.println(true);
            }
        }

    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String descrip) {
        findTransactions.description.sendKeys(descrip);

    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        List<WebElement> descriptionList = Driver.get().findElements(By.xpath("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[2]"));
        for( WebElement eachDescription : descriptionList){
            Assert.assertTrue(eachDescription.getText().contains(description));
        }

    }

    @But("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {
        List<WebElement> descriptionList = Driver.get().findElements(By.xpath("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[2]"));
        for( WebElement eachDescription : descriptionList){
            Assert.assertTrue(eachDescription.getText().contains(description));
        }
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        List<WebElement> allDeposits = Driver.get().findElements(By.xpath("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[3]"));

        System.out.println("Size " + allDeposits.size());
        Assert.assertFalse(allDeposits.isEmpty());
        Assert.assertTrue(allDeposits.size() >= 1);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        List<WebElement> allWithdrawal = Driver.get().findElements(By.xpath("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[4]"));
        System.out.println("Size " + allWithdrawal.size());
        Assert.assertFalse(allWithdrawal.isEmpty());
        Assert.assertTrue(allWithdrawal.size() >= 1);
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }



    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }




}