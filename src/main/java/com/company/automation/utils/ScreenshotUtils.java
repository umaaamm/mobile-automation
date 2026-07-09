package com.company.automation.utils;

import com.company.automation.driver.DriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    @Attachment(
            value = "{name}",
            type = "image/png"
    )
    
    public static byte[] attach(String name) {
        return ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }

    public static String capture(String scenarioName) {
        try {
            File source = ((TakesScreenshot) DriverManager.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String fileName = scenarioName
                    .replace(" ", "_")
                    + "_"
                    + timestamp
                    + ".png";

            File destination = new File(
                    System.getProperty("user.dir")
                            + "/screenshots/"
                            + fileName
            );

            FileUtils.copyFile(source, destination);

            return destination.getAbsolutePath();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}