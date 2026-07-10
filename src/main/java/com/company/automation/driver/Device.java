package com.company.automation.driver;

public record Device(
        String name,
        String udid,
        String platformVersion,
        int systemPort
) {
}
