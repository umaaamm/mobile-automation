package com.company.automation.hooks;

import com.company.automation.config.RuntimeConfig;
import com.company.automation.driver.DriverFactory;
import com.company.automation.flows.FlowManager;
import com.company.automation.logger.LogManager;
import com.company.automation.logger.LoggerUtils;
import com.company.automation.utils.AllureUtils;
import com.company.automation.utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    public static FlowManager flow;

    @Before
    public void beforeScenario(Scenario scenario) throws Exception {
        LogManager.clear();
        LoggerUtils.scenario(
                scenario.getName()
        );

        DriverFactory.initialize();

        flow = new FlowManager();
    }

    @After
    public void afterScenario(Scenario scenario) {

        AllureUtils.attachText(
                "Device Information",
                """
                        Device Name     : %s
                        Android Version : %s
                        UDID            : %s
                        """.formatted(
                        RuntimeConfig.get("device.name"),
                        RuntimeConfig.get("platform.version"),
                        RuntimeConfig.get("device.udid")
                )
        );

        AllureUtils.attachText(
                "Execution Log",
                LogManager.getLogs()
        );

        if (scenario.isFailed()) {
            String path = ScreenshotUtils.capture(
                    scenario.getName()
            );

            AllureUtils.attachScreenshot("Failed Screenshot");

            LoggerUtils.fail("Screenshot : " + path);

            ScreenshotUtils.capture(
                    scenario.getName()
            );
            ScreenshotUtils.attach(
                    scenario.getName()
            );
        }

        DriverFactory.quit();
    }
}