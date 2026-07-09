package com.company.automation.logger;

public final class LogManager {

    private static final StringBuilder LOGS = new StringBuilder();

    private LogManager() {
    }

    public static void append(String message) {

        LOGS.append(message)
                .append(System.lineSeparator());

    }

    public static String getLogs() {

        return LOGS.toString();

    }

    public static void clear() {

        LOGS.setLength(0);

    }

}