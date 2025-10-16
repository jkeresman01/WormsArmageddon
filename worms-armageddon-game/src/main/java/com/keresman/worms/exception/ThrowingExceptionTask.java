package com.keresman.worms.exception;

@FunctionalInterface
public interface ThrowingExceptionTask<E extends Exception> {

    void execute() throws E;
}
