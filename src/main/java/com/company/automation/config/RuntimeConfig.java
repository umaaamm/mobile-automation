package com.company.automation.config;

public final class RuntimeConfig {

    private RuntimeConfig() {
    }

    public static String get(String key) {
        return System.getProperty(key);
    }

    public static String get(String key, String defaultValue) {
        return System.getProperty(key, defaultValue);
    }

}