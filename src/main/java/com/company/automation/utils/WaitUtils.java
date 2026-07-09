package com.company.automation.utils;

import com.company.automation.config.ConfigManager;
import com.company.automation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitUtils {

    private WaitUtils() {
    }

    public static void shortDelay() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static WebDriverWait getWait() {
        return new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(
                        Long.parseLong(
                                ConfigManager.get("explicit.wait")
                        )
                )
        );
    }

    public static void waitForMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static WebElement visible(By locator) {

        return getWait().until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

    }

    public static WebElement clickable(By locator) {

        return getWait().until(
                ExpectedConditions.elementToBeClickable(locator)
        );

    }

}