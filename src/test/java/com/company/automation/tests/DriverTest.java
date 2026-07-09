package com.company.automation.tests;

import com.company.automation.base.BaseTest;
import com.company.automation.driver.DriverFactory;
import com.company.automation.driver.DriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class DriverTest extends BaseTest {

    @Test
    void launchApplication() throws Exception {
        Thread.sleep(5000);
    }

    @Test
    void debugLocator() throws Exception {
        DriverFactory.initialize();
        
        Thread.sleep(3000);

        var driver = DriverManager.getDriver();

        System.out.println(driver.findElements(By.id("input_username")).size());

        DriverFactory.quit();
    }

}