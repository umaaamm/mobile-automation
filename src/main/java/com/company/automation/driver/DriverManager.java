package com.company.automation.driver;

import io.appium.java_client.android.AndroidDriver;

public final class DriverManager {

    private DriverManager() {
    }

    public static AndroidDriver getDriver() {
        return DriverFactory.getDriver();
    }
}