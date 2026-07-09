package com.company.automation.utils;

import com.company.automation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class GestureActions {
    private final PointerInput finger =
            new PointerInput(
                    PointerInput.Kind.TOUCH,
                    "finger");

    public void swipeUp() {
        Dimension size =
                DriverManager.getDriver()
                        .manage()
                        .window()
                        .getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        Sequence swipe =
                new Sequence(finger, 1);

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        startX,
                        startY));

        swipe.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(500),
                        PointerInput.Origin.viewport(),
                        startX,
                        endY));

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        DriverManager.getDriver()
                .perform(List.of(swipe));

    }

    public void scrollUntilVisible(By locator) {
        for (int i = 0; i < 5; i++) {
            if (!DriverManager.getDriver()
                    .findElements(locator)
                    .isEmpty()) {
                return;
            }

            swipeUp();
        }

        throw new RuntimeException(
                "Element not found : " + locator);
    }
}