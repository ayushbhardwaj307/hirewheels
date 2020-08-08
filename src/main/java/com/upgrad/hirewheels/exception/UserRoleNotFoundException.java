package com.upgrad.hirewheels.exception;

public class UserRoleNotFoundException extends  Exception{
    public UserRoleNotFoundException() {
    }

    public UserRoleNotFoundException(String message) {
        super(message);
    }

    public UserRoleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserRoleNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserRoleNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
