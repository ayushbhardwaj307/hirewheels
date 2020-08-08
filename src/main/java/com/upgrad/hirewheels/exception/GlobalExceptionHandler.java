package com.upgrad.hirewheels.exception;

public class GlobalExceptionHandler extends Exception {
    public GlobalExceptionHandler() {
    }

    public GlobalExceptionHandler(String message) {
        super(message);
    }

    public GlobalExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalExceptionHandler(Throwable cause) {
        super(cause);
    }

    public GlobalExceptionHandler(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
