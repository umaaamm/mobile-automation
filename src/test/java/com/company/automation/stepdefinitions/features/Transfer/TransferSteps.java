package com.company.automation.stepdefinitions.features.Transfer;

import com.company.automation.hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransferSteps {

    @When("user enters transfer amount {string}")
    public void enterTransferAmount(String amount) {
        Hooks.flow.transfer()
                .inputAmount(amount);
    }

    @And("user selects destination bank {string}")
    public void selectDestinationBank(String bank) {
        Hooks.flow
                .transfer()
                .selectBank(bank);
    }

    @And("user clicks Continue button")
    public void clickContinueButton() {
        Hooks.flow
                .transfer()
                .clickTransferInputAmount();
    }

    @Then("user should see Transfer Inquiry page")
    public void verifyTransferInquiryPage() {
        Hooks.flow
                .transfer()
                .verifyTransferInquiryPage();
    }

    @When("user clicks Continue on Inquiry page")
    public void clickContinueInquiry() {
        Hooks.flow
                .transfer()
                .clickTransferInquiry();
    }

    @Then("user should see Transfer Confirmation page")
    public void verifyTransferConfirmationPage() {
        Hooks.flow
                .transfer()
                .verifyTransferConfirmationPage();
    }

    @When("user clicks Confirm Transfer button")
    public void clickConfirmTransfer() {
        Hooks.flow
                .transfer()
                .clickConfirmTransfer();
    }

    @Then("user should see Transfer Success page")
    public void verifyTransferSuccessPage() {
        Hooks.flow
                .transfer()
                .verifyTransferSuccessPage();
    }

    @When("user clicks Back to Dashboard button")
    public void clickBackToDashboard() {
        Hooks.flow
                .transfer()
                .clickBackToDashboard();
    }
    
    @Then("user should see Error Message")
    public void verifyDisplayedErrorMessage() {
        Hooks.flow
                .transfer()
                .verifyErrorShowTransfer();
    }
}