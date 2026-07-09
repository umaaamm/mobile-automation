package com.company.automation.driver;

import com.company.automation.config.ConfigManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public final class DriverFactory {

    private static AndroidDriver driver;

    private DriverFactory() {
    }

    public static void initialize() throws MalformedURLException {

        if (driver != null) {
            return;
        }

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName(
                ConfigManager.get("platform.name"));

        options.setAutomationName(
                ConfigManager.get("automation.name"));

        options.setDeviceName(
                ConfigManager.get("device.name"));

        options.setApp(
                System.getProperty("user.dir")
                        + "/"
                        + ConfigManager.get("app.path"));

        driver = new AndroidDriver(
                URI.create(
                        ConfigManager.get("appium.url")
                ).toURL(),
                options);

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(
                        Long.parseLong(
                                ConfigManager.get("implicit.wait")
                        )
                )
        );

    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            throw new RuntimeException(
                    "Driver has not been initialized.");
        }

        return driver;

    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}