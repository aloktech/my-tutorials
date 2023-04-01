package com.imos.core.exception;

import java.util.concurrent.Callable;

public class Try {

    public static <T> Response<?> execute(Callable<T> callable) {
        try {
            return new Success<>(callable.call());
        } catch (Exception e) {
            return new Failure(e);
        }
    }
}
