package com.company.automation.utils;

import com.company.automation.locators.Locator;
import com.company.automation.logger.LoggerUtils;
import org.openqa.selenium.WebElement;

public class ElementActions {

    private final KeyboardActions keyboard =
            new KeyboardActions();

    public void enterText(Locator locator, String value) {

        RetryExecutor.execute(3, () -> {
            LoggerUtils.step("Input enterText : " + locator.name());

            WebElement element =
                    WaitUtils.visible(locator.by());
            element.click();
            WaitUtils.shortDelay();
            element.clear();
            element.sendKeys(value);
            keyboard.hide();
        });
    }

    public void click(Locator locator) {
        RetryExecutor.execute(3, () -> {
            LoggerUtils.action("Click : " + locator.name());
            WaitUtils.clickable(locator.by()).click();
        });
    }

    public void type(Locator locator,
                     String value) {
        RetryExecutor.execute(3, () -> {
            LoggerUtils.step("Input : " + locator.name());

            WebElement element = WaitUtils.visible(locator.by());
            element.click();
            WaitUtils.waitForMillis(300);
            element.clear();
            element.sendKeys(value);
        });
    }

    public String text(Locator locator) {
        LoggerUtils.step("Text : " + locator.name());

        return WaitUtils.visible(locator.by()).getText();
    }

    public boolean displayed(Locator locator) {
        LoggerUtils.step("Displayed : " + locator.name());

        return WaitUtils.visible(locator.by()).isDisplayed();
    }

}