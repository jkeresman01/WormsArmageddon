package com.keresman.worms.exception;

@FunctionalInterface
public interface ThrowingSupplier<T, E extends Exception> {

    T get() throws E;
}
