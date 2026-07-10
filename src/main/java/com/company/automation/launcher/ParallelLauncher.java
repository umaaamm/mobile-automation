package com.company.automation.launcher;

import com.company.automation.driver.Device;
import com.company.automation.driver.DeviceManager;
import com.company.automation.report.*;
import com.company.automation.utils.MavenUtils;

import java.util.ArrayList;
import java.util.List;

public final class ParallelLauncher {

    private ParallelLauncher() {
    }

    private static final String RUNNER =
            System.getProperty("runner", "RunSmokeTest");

    private static final String TAGS =
            System.getProperty("tags", "@smoke");

    public static void main(String[] args) throws Exception {

        List<Device> devices = DeviceManager.getDevices();

        if (devices.isEmpty()) {
            System.out.println("No Android devices detected.");
            return;
        }

        printBanner(devices);

        executeTests(devices);

        generateReports(devices);

        BrowserLauncher.open();
    }

    private static void printBanner(List<Device> devices) {

        System.out.println("==========================================");
        System.out.println(" Mobile Automation Parallel Execution");
        System.out.println("==========================================");
        System.out.println("Runner  : " + RUNNER);
        System.out.println("Tags    : " + TAGS);
        System.out.println("Devices : " + devices.size());

        devices.forEach(device ->
                System.out.printf(
                        " - %s (%s)%n",
                        device.name(),
                        device.udid()
                ));

        System.out.println("==========================================");
    }

    private static void executeTests(List<Device> devices)
            throws Exception {

        List<Process> processes = new ArrayList<>();

        for (Device device : devices) {

            System.out.printf(
                    "Starting %s...%n",
                    device.name()
            );

            Process process =
                    createProcess(device)
                            .inheritIO()
                            .start();

            processes.add(process);
        }

        boolean hasFailure = false;

        for (Process process : processes) {

            int exitCode = process.waitFor();

            if (exitCode != 0) {
                hasFailure = true;
            }

        }

        System.out.println("==========================================");
        System.out.println("All devices finished.");
        System.out.println("==========================================");

        if (hasFailure) {
            System.out.println("⚠ Some executions failed.");
        } else {
            System.out.println("✅ All executions completed successfully.");
        }
    }

    private static void generateReports(List<Device> devices)
            throws Exception {

        System.out.println();
        System.out.println("Generating Allure Reports...");

        List<DeviceSummary> summaries =
                new ArrayList<>();

        for (Device device : devices) {

            System.out.println(
                    "Generating report : "
                            + device.name()
            );

            ReportGenerator.generate(
                    device.name()
            );

            summaries.add(
                    SummaryReader.read(
                            device.name()
                    )
            );

        }

        DashboardGenerator.generate(
                summaries
        );

        System.out.println();
        System.out.println("Dashboard generated successfully.");
    }

    private static ProcessBuilder createProcess(Device device) {

        return new ProcessBuilder(

                MavenUtils.getCommand(),

                "test",

                "-Dtest=" + RUNNER,

                "-Dcucumber.filter.tags=" + TAGS,

                "-Ddevice.name=" + device.name(),

                "-Ddevice.udid=" + device.udid(),

                "-Dplatform.version=" + device.platformVersion(),

                "-Dsystem.port=" + device.systemPort(),

                "-Dallure.results.directory=allure-results/" + device.name()

        );

    }

}