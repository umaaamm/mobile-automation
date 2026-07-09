package com.company.automation.assertion;

import org.junit.jupiter.api.Assertions;

public final class AssertionHelper {

    private AssertionHelper() {
    }

    public static void equals(String expected, String actual) {
        Assertions.assertEquals(expected, actual);
    }

    public static void trueCondition(boolean condition) {
        Assertions.assertTrue(condition);
    }

    public static void falseCondition(boolean condition) {
        Assertions.assertFalse(condition);
    }

    public static void notNull(Object object) {
        Assertions.assertNotNull(object);
    }

}
