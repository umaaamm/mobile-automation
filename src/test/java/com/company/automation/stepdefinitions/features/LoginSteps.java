package com.company.automation.stepdefinitions.features;

import com.company.automation.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    @Given("user opens the application")
    public void openApplication() {
    }

    @When("user login with username {string} and password {string}")
    public void login(String username, String password) {
        Hooks.flow
                .login()
                .login(username, password);
    }

    @Then("user should see dashboard")
    public void verifyDashboard() {
        Hooks.flow
                .dashboard()
                .verifyDashboardDisplayed();
    }
//
//    @Then("user should see dashboard")
//    public void verifyDashboard() {
//        throw new RuntimeException("Testing Screenshot");
//    }
}