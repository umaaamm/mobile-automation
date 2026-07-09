package com.company.automation.locators;

import org.openqa.selenium.By;

public record Locator(
        String name,
        By by
) {
}
