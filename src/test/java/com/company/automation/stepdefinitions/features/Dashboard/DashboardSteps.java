package com.company.automation.stepdefinitions.features.Dashboard;

import com.company.automation.hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps {

    @Then("user should see dashboard")
    public void verifyDashboardShow() {
        Hooks.flow
                .dashboard()
                .verifyDashboardDisplayed();
    }

    @When("user clicks Transfer button")
    public void clickTransferButton() {
        Hooks.flow
                .dashboard()
                .clickButtonTransfer();
    }

    @Then("user should be on Transfer page")
    public void verifyTransferPage() {
        Hooks.flow.dashboard().verifyPageTransfer();
    }

    @When("user clicks Logout button")
    public void clickLogoutButton() {
        Hooks.flow
                .dashboard()
                .clickButtonLogout();
    }

    @Then("user should see Login page")
    public void verifyLoginPage() {
        Hooks.flow
                .login().verifyPageLogin();
    }
}