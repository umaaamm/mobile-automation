@smoke
Feature: Dashboard

  Background:
    Given user opens the application
    And user login with username "admin" and password "123456"

  Scenario: Navigate to Transfer Page
    Then user should see dashboard
    When user clicks Transfer button
    Then user should be on Transfer page

  Scenario: Logout
      Then user should see dashboard
      When user clicks Logout button
      Then user should see Login page