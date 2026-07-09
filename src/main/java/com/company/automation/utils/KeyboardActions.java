package com.company.automation.utils;

import com.company.automation.driver.DriverManager;

public class KeyboardActions {
    public void hide() {
        try {
            DriverManager.getDriver()
                    .hideKeyboard();
        } catch (Exception ignored) {
        }
    }
}
