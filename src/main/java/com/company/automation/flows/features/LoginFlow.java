package com.company.automation.flows.features;

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

}