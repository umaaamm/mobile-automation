package com.company.automation.report;

import java.io.IOException;

public final class ReportGenerator {

    private ReportGenerator() {
    }
    
    public static void generate(String device)
            throws IOException, InterruptedException {

        ProcessBuilder builder =
                new ProcessBuilder(
                        "allure",
                        "generate",
                        "allure-results/" + device,
                        "-o",
                        "reports/" + device,
                        "--clean"
                );


        builder.inheritIO();

        Process process =
                builder.start();

        int exit =
                process.waitFor();

        if (exit != 0) {
            throw new RuntimeException(
                    "Failed generate allure report : "
                            + device
            );
        }
    }
}
