package com.company.automation.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public final class CommandUtils {

    private CommandUtils() {
    }

    public static String execute(String command) {
        try {
            Process process =
                    Runtime.getRuntime().exec(command);

            process.waitFor();

            return new BufferedReader(

                    new InputStreamReader(
                            process.getInputStream()
                    )

            ).lines()
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
