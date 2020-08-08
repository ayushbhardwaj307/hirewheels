package com.upgrad.hirewheels.exception;

public class DuplicateUserDetailsException extends Exception {
    public DuplicateUserDetailsException() {
    }

    public DuplicateUserDetailsException(String message) {
        super(message);
    }

    public DuplicateUserDetailsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateUserDetailsException(Throwable cause) {
        super(cause);
    }

    public DuplicateUserDetailsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
