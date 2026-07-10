package com.company.automation.driver;

import io.appium.java_client.android.AndroidDriver;

public final class DriverManager {

    private DriverManager() {
    }

    private static final ThreadLocal<AndroidDriver> DRIVER =
            new ThreadLocal<>();

    public static void setDriver(AndroidDriver driver) {
        DRIVER.set(driver);
    }

    public static AndroidDriver getDriver() {

        AndroidDriver driver = DRIVER.get();

        if (driver == null) {
            throw new RuntimeException("Driver not initialized");
        }

        return driver;
    }

    public static void unload() {
        DRIVER.remove();
    }

}