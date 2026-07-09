package com.company.automation.pages.features.login;

import com.company.automation.base.BasePage;
import com.company.automation.locators.features.login.LoginLocator;

public class LoginPage extends BasePage {

    public void inputUsername(String username) {
        element.type(LoginLocator.USERNAME, username);
    }

    public void inputPassword(String password) {
        element.type(LoginLocator.PASSWORD, password);
    }

    public void clickLogin() {
        element.click(LoginLocator.LOGIN_BUTTON);
    }

}