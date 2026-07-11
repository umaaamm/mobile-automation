package com.company.automation.locators.features.dashboard;

import com.company.automation.locators.Locator;
import com.company.automation.locators.LocatorFactory;

public final class DashboardLocator {

    private DashboardLocator() {
    }

    public static final Locator TITLE = new Locator("Title Halaman Dashboard",
            LocatorFactory.flutterId("selamat_datang"));
    public static final Locator BUTTON_TRANSFER = new Locator("Button Transfer",
            LocatorFactory.flutterId("btn_transfer"));
    public static final Locator BUTTON_LOGOUT = new Locator("Button Logout",
            LocatorFactory.flutterId("btn_logout"));
}