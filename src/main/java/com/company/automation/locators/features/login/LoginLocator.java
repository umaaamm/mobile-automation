package com.company.automation.locators.features.login;

import com.company.automation.locators.Locator;
import com.company.automation.locators.LocatorFactory;

public final class LoginLocator {

    private LoginLocator() {
    }

    public static final Locator USERNAME = new Locator(
            "Username",
            LocatorFactory.flutterId("input_username"));

    public static final Locator PASSWORD = new Locator("Password",
            LocatorFactory.flutterId("input_password"));

    public static final Locator LOGIN_BUTTON = new Locator("Button Login",
            LocatorFactory.flutterId("btn_login"));

}