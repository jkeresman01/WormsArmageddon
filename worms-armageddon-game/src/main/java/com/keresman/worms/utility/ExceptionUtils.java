package com.keresman.worms.utility;

import com.keresman.worms.exception.ThrowingExceptionTask;
import com.keresman.worms.exception.ThrowingSupplier;

public final class ExceptionUtils {

    private ExceptionUtils() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    public static <E extends Exception> void executeUnchecked(
            ThrowingExceptionTask<E> task, String message) {
        try {
            task.execute();
        } catch (Exception e) {
            throw new RuntimeException(message, e);
        }
    }

    public static <T, E extends Exception> T callUnchecked(
            ThrowingSupplier<T, E> supplier, String message) {
        try {
            return supplier.get();
        } catch (Exception e) {
            throw new RuntimeException(message, e);
        }
    }
}
