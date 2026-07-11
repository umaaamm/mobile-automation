package com.company.automation.pages.features.transfer;

import com.company.automation.base.BasePage;
import com.company.automation.locators.features.transfer.TransferLocator;

public class TransferPage extends BasePage {
    public boolean isDisplayed() {
        return element.displayed(TransferLocator.TITLE_TRANSFER);
    }

    public void inputAmount(String amount) {
        element.type(TransferLocator.INPUT_AMOUNT, amount);
    }

    public void selectBank(String bank) {
        element.selectDropdown(TransferLocator.CHOOSE_BANK, bank);
    }

    public void click_lanjut_input_amount() {
        element.click(TransferLocator.CLICK_LANJUT_INPUT_AMOUNT);
    }

    public void click_lanjut_inquiry() {
        element.click(TransferLocator.CLICK_LANJUT_INQUIRY);
    }

    public void click_lanjut_confirmation() {
        element.click(TransferLocator.CLICK_LANJUT_CONFIRMATION);
    }

    public void click_lanjut_success_transfer() {
        element.click(TransferLocator.CLICK_SUSCCESS_BACK_DASHBOARD);
    }

    public boolean isDisplayedInquiry() {
        return element.displayed(TransferLocator.TITLE_INQURIY);
    }

    public boolean isDisplayedConfirmation() {
        return element.displayed(TransferLocator.TITLE_CONFIRMATION);
    }

    public boolean isDisplayedSuccess() {
        return element.displayed(TransferLocator.TITLE_SUCCESS);
    }

    public boolean isDisplayedErrorText() {
        return element.displayed(TransferLocator.ERROR_TEXT);
    }
    
}
