package com.company.automation.driver;

import com.company.automation.utils.CommandUtils;

import java.util.ArrayList;
import java.util.List;

public final class DeviceManager {

    private DeviceManager() {
    }

    private static String getProperty(
            String udid,
            String property
    ) {

        return CommandUtils.execute(

                "adb -s "
                        + udid
                        + " shell getprop "
                        + property

        ).trim();

    }

    public static List<Device> getDevices() {
        String output =
                CommandUtils.execute("adb devices -l");

        List<Device> devices =
                new ArrayList<>();

        String[] lines =
                output.split("\n");

        int port = 8201;

        for (String line : lines) {
            if (line.startsWith("List"))
                continue;

            if (line.isBlank())
                continue;

            String[] values =
                    line.split("\\s+");

            String udid =
                    values[0];

            String name =
                    getProperty(
                            udid,
                            "ro.product.model"
                    );

            String version =
                    getProperty(
                            udid,
                            "ro.build.version.release"
                    );

            devices.add(
                    new Device(
                            name,
                            udid,
                            version,
                            port++
                    )
            );
        }

        return devices;
    }

    public static void main(String[] args) {
        DeviceManager
                .getDevices()
                .forEach(System.out::println);
    }
}