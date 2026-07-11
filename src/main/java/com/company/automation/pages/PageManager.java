package com.company.automation.pages;

import com.company.automation.pages.features.home.DashboardPage;
import com.company.automation.pages.features.login.LoginPage;
import com.company.automation.pages.features.transfer.TransferPage;

public class PageManager {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private TransferPage transferPage;

    public LoginPage login() {

        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        return loginPage;
    }

    public DashboardPage dashboard() {

        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }

        return dashboardPage;
    }

    public TransferPage transfer() {
        if (transferPage == null) {
            transferPage = new TransferPage();
        }

        return transferPage;
    }

}