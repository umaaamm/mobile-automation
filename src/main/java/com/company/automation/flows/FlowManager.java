package com.company.automation.flows;

import com.company.automation.flows.features.DashboardFlow;
import com.company.automation.flows.features.LoginFlow;
import com.company.automation.pages.PageManager;

public class FlowManager {

    private final PageManager page = new PageManager();

    private LoginFlow loginFlow;
    private DashboardFlow dashboardFlow;

    public LoginFlow login() {

        if (loginFlow == null) {
            loginFlow = new LoginFlow(page);
        }

        return loginFlow;
    }

    public DashboardFlow dashboard() {

        if (dashboardFlow == null) {
            dashboardFlow = new DashboardFlow(page);
        }

        return dashboardFlow;
    }

}