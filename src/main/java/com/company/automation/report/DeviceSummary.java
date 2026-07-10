package com.company.automation.report;

public record DeviceSummary(
        String device,
        int passed,
        int failed,
        int broken,
        int skipped,
        long duration
) {
}
