package com.company.automation.driver;

public final class DeviceContext {

    private DeviceContext() {
    }

    private static final ThreadLocal<Device> DEVICE =
            new ThreadLocal<>();

    public static void set(Device device) {
        DEVICE.set(device);
    }

    public static Device get() {
        Device device = DEVICE.get();
        if (device == null) {
            throw new RuntimeException(
                    "Device has not been assigned to current thread."
            );
        }

        return device;

    }

    public static void unload() {
        DEVICE.remove();
    }

}
