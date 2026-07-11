@smoke
Feature: Transfer

  Background:
    Given user opens the application
    And user login with username "admin" and password "123456"

  Scenario: Successful Transfer
    Then user should see dashboard

    When user clicks Transfer button
    Then user should be on Transfer page

    When user enters transfer amount "100000"
    And user selects destination bank "BCA"
    And user clicks Continue button
    Then user should see Transfer Inquiry page

    When user clicks Continue on Inquiry page
    Then user should see Transfer Confirmation page

    When user clicks Confirm Transfer button
    Then user should see Transfer Success page

    When user clicks Back to Dashboard button
    Then user should see dashboard

  Scenario: Failed Transfer and input amount is null
    Then user should see dashboard

    When user clicks Transfer button
    Then user should be on Transfer page

    When user enters transfer amount ""
    And user clicks Continue button
    Then user should see Error Message