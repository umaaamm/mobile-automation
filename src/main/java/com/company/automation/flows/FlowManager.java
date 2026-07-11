package com.company.automation.flows;

import com.company.automation.flows.features.dashboard.DashboardFlow;
import com.company.automation.flows.features.login.LoginFlow;
import com.company.automation.flows.features.transfer.TransferFlow;
import com.company.automation.pages.PageManager;

public class FlowManager {

    private final PageManager page = new PageManager();

    private LoginFlow loginFlow;
    private DashboardFlow dashboardFlow;
    private TransferFlow transferFlow;

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

    public TransferFlow transfer() {

        if (transferFlow == null) {
            transferFlow = new TransferFlow(page);
        }

        return transferFlow;
    }

}