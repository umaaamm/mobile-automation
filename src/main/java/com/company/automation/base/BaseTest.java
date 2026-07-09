package com.company.automation.base;

import com.company.automation.driver.DriverFactory;
import com.company.automation.flows.FlowManager;
import com.company.automation.utils.ScreenshotUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public abstract class BaseTest {

    protected FlowManager flow;

    @BeforeEach
    public void setup() throws Exception {
        DriverFactory.initialize();

        flow = new FlowManager();
    }

    @AfterEach
    void teardown(TestInfo info) {
        ScreenshotUtils.capture(info.getDisplayName());

        DriverFactory.quit();
    }
}