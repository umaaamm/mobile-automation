package com.company.automation.flows.features.dashboard;

import com.company.automation.assertion.AssertionHelper;
import com.company.automation.logger.LoggerUtils;
import com.company.automation.pages.PageManager;

public class DashboardFlow {

    private final PageManager page;

    public DashboardFlow(PageManager page) {
        this.page = page;
    }

    public void verifyDashboardDisplayed() {
        LoggerUtils.verify(
                "Verify Dashboard"
        );

        AssertionHelper.trueCondition(
                page.dashboard().isDisplayed()
        );

        LoggerUtils.pass(
                "Dashboard displayed"
        );
    }

    public void clickButtonTransfer() {
        page.dashboard().clickButtonTransfer();
    }

    public void clickButtonLogout() {
        page.dashboard().clickButtonLogout();
    }

    public void verifyPageTransfer() {
        AssertionHelper.trueCondition(
                page.transfer().isDisplayed()
        );
    }

    public void verifyTitle(String expectedTitle) {
        AssertionHelper.equals(
                expectedTitle,
                page.dashboard().getTitle()
        );
    }
}