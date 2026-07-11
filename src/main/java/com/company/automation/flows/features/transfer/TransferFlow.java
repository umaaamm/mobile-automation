package com.company.automation.flows.features.transfer;

import com.company.automation.assertion.AssertionHelper;
import com.company.automation.pages.PageManager;

public class TransferFlow {
    private final PageManager page;

    public TransferFlow(PageManager page) {
        this.page = page;
    }

    public void inputAmount(String amount) {
        page.transfer().inputAmount(amount);
    }

    public void selectBank(String bank) {
        page.transfer().selectBank(bank);
    }

    public void clickTransferInputAmount() {
        page.transfer().click_lanjut_input_amount();
    }

    public void verifyTransferInquiryPage() {
        page.transfer().isDisplayedInquiry();
    }

    public void clickTransferInquiry() {
        page.transfer().click_lanjut_inquiry();
    }

    public void verifyTransferConfirmationPage() {
        page.transfer().isDisplayedConfirmation();
    }

    public void clickConfirmTransfer() {
        page.transfer().click_lanjut_confirmation();
    }

    public void verifyTransferSuccessPage() {
        page.transfer().isDisplayedSuccess();
    }

    public void clickBackToDashboard() {
        page.transfer().click_lanjut_success_transfer();
    }

    public void verifyErrorShowTransfer() {
        AssertionHelper.trueCondition(
                page.transfer().isDisplayedErrorText()
        );
    }
}
