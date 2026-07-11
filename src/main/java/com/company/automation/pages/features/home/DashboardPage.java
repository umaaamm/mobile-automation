package com.company.automation.pages.features.home;

import com.company.automation.base.BasePage;
import com.company.automation.locators.features.dashboard.DashboardLocator;

public class DashboardPage extends BasePage {

    public boolean isDisplayed() {
        return element.displayed(DashboardLocator.TITLE);
    }

    public String getTitle() {
        return element.text(DashboardLocator.TITLE);
    }

    public void clickButtonTransfer() {
        element.click(DashboardLocator.BUTTON_TRANSFER);
    }

    public void clickButtonLogout() {
        element.click(DashboardLocator.BUTTON_LOGOUT);
    }

}