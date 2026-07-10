package com.company.automation.driver;

import com.company.automation.config.ConfigManager;
import com.company.automation.config.RuntimeConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public final class DriverFactory {


    private DriverFactory() {
    }

    public static void initialize() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName(
                ConfigManager.get("platform.name"));

        options.setAutomationName(
                ConfigManager.get("automation.name"));


        options.setDeviceName(
                RuntimeConfig.get(
                        "device.name"
                )
        );

        options.setUdid(
                RuntimeConfig.get(
                        "device.udid"
                )
        );

        options.setPlatformVersion(
                RuntimeConfig.get(
                        "platform.version"
                )
        );

        options.setSystemPort(
                Integer.parseInt(
                        RuntimeConfig.get(
                                "system.port",
                                "8201"
                        )
                )
        );

        options.setApp(
                System.getProperty("user.dir")
                        + "/"
                        + ConfigManager.get("app.path"));

        String appiumUrl = RuntimeConfig.get(
                "appium.url",
                ConfigManager.get("appium.url")
        );

        AndroidDriver driver =
                new AndroidDriver(
                        URI.create(appiumUrl).toURL(),
                        options
                );

        DriverManager.setDriver(driver);

        DriverManager
                .getDriver()
                .manage().timeouts().implicitlyWait(
                        Duration.ofSeconds(
                                Long.parseLong(
                                        ConfigManager.get("implicit.wait")
                                )
                        )
                );
    }

    public static void quit() {
        try {
            DriverManager
                    .getDriver()
                    .quit();

        } catch (Exception ignored) {
        }

        DriverManager.unload();
    }
}