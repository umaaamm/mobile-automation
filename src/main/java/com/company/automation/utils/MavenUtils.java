package com.company.automation.utils;

import java.io.File;

public final class MavenUtils {

    private MavenUtils() {
    }

    public static String getCommand() {

        if (new File("mvnw").exists()) {
            return "./mvnw";
        }

        if (System.getProperty("os.name")
                .toLowerCase()
                .contains("win")) {
            return "mvn.cmd";
        }

        return "mvn";
    }

}