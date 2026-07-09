package com.company.automation.locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public final class LocatorFactory {

    private LocatorFactory() {
    }

    public static By id(String value) {
        return AppiumBy.id(value);
    }

    public static By flutterId(String id) {
        return By.xpath("//*[@resource-id='" + id + "']");
    }

    public static By accessibility(String value) {
        return AppiumBy.accessibilityId(value);
    }
}