package com.company.automation.driver;

public final class RuntimeDevice {

    private RuntimeDevice() {
    }

    public static Device get() {
        return new Device(
                System.getProperty("device.name"),
                System.getProperty("device.udid"),
                System.getProperty("platform.version"),
                Integer.parseInt(
                        System.getProperty(
                                "system.port",
                                "8201"
                        )
                )
        );
    }
}
