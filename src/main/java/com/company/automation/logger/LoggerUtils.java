package com.company.automation.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoggerUtils {

    private LoggerUtils() {
    }

    private static final Logger logger =
            LoggerFactory.getLogger("Automation");

    public static void scenario(String scenario) {
        logger.info("==================================================");
        logger.info("Scenario : {}", scenario);
        logger.info("==================================================");
        LogManager.append("[INFO] " + scenario);
    }

    public static void step(String message) {
        logger.info("[STEP] {}", message);
        LogManager.append("[STEP] " + message);
    }

    public static void action(String message) {
        logger.info("[ACTION] {}", message);
        LogManager.append("[ACTION] " + message);
    }

    public static void verify(String message) {
        logger.info("[VERIFY] {}", message);
        LogManager.append("[VERIFY] " + message);
    }

    public static void pass(String message) {
        logger.info("[PASS] {}", message);
        LogManager.append("[PASS] " + message);
    }

    public static void fail(String message) {
        logger.error("[FAIL] {}", message);
        LogManager.append("[FAIL] " + message);
    }

    public static void warn(String message) {
        logger.warn("[WARN] {}", message);
        LogManager.append("[WARN] " + message);
    }

}