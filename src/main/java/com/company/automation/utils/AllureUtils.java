package com.company.automation.utils;

import com.company.automation.driver.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public final class AllureUtils {

    private AllureUtils() {
    }

    public static void attachScreenshot(String name) {

        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment(
                name,
                "image/png",
                new ByteArrayInputStream(screenshot),
                ".png"
        );
    }

    public static void attachText(
            String name,
            String value
    ) {

        Allure.addAttachment(
                name,
                "text/plain",
                new ByteArrayInputStream(
                        value.getBytes(StandardCharsets.UTF_8)
                ),
                ".txt"
        );

    }
}