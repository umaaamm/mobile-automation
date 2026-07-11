package com.company.automation.flows.features.login;

import com.company.automation.assertion.AssertionHelper;
import com.company.automation.pages.PageManager;

public class LoginFlow {

    private final PageManager page;

    public LoginFlow(PageManager page) {
        this.page = page;
    }

    public void login(String username, String password) {
        page.login()
                .inputUsername(username);
        page.login()
                .inputPassword(password);
        page.login()
                .clickLogin();
    }

    public void verifyPageLogin() {
        AssertionHelper.trueCondition(
                page.login().isDisplayed()
        );
    }

    public void verifyErrorShow() {
        AssertionHelper.trueCondition(
                page.login().isErrorDisplayed()
        );
    }

}