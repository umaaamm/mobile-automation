@smoke
Feature: Login
  Scenario: Login with valid credentials
    Given user opens the application
    When user login with username "admin" and password "123456"
    Then user should see dashboard