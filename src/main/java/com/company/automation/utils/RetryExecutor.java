package com.company.automation.utils;

public final class RetryExecutor {
    private RetryExecutor() {
    }

    public static void execute(int retry, Runnable runnable) {
        RuntimeException exception = null;

        for (int i = 0; i < retry; i++) {
            try {
                runnable.run();

                return;
            } catch (RuntimeException e) {
                exception = e;
                WaitUtils.shortDelay();
            }
        }

        throw exception;
    }
}
