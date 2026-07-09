package com.company.automation.tests;

import com.company.automation.config.ConfigManager;
import org.junit.jupiter.api.Test;

public class ConfigTest {

    @Test
    void printConfiguration() {

        System.out.println("Appium URL : "
                + ConfigManager.get("appium.url"));

        System.out.println("Platform : "
                + ConfigManager.get("platform.name"));

        System.out.println("Automation : "
                + ConfigManager.get("automation.name"));

        System.out.println("Device : "
                + ConfigManager.get("device.name"));

        System.out.println("APK : "
                + ConfigManager.get("app.path"));

    }

}