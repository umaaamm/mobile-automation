package com.company.automation.tests;

import com.company.automation.base.BaseTest;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    void loginSuccess() {
        flow.login()
                .login("admin", "123456");

        flow.dashboard()
                .verifyDashboardDisplayed();

    }

    @Test
    void loginFailed() {
        flow.login()
                .login("", "123456");

    }

}