@smoke
Feature:Navigating to specific accounts in Accounts Activity
  @AccountActivity
  Scenario: Savings account redirect
    Given the user is logged in
    When the user clicks on Savings link on the Account Summary PAGE
    Then the Account Activity page should be displayed
    And Account drop down should have Saving selected
  @Brokerage
  Scenario: Brokerage account redirect
    Given the user is logged in
    When the user clicks on Brokerage link on the Account Summary PAGE
    Then the Account Activity page should be displayed
    And Account drop down should have Brokerage selected
  @Checking
  Scenario: Checking account redirect
    Given the user is logged in
    When the user clicks on Cheking link on the Account summary page
    Then the Account Activity page should be displayed
    And Account drop down should have Cheking selected
  @CreditCard
  Scenario: Credit Card account redirect
    Given the user is logged in
    When the user clicks on Credit Card link on the Account Summary Page
    Then the Account Activity page should be displayed
    And Account drop down should have Credit Card selected
  @LoanAccount
  Scenario: Loan account redirect
    Given the user is logged in
    When the user click on Loan link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have Loan selected