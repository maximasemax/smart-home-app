package com.smart.house.app.exception;

public class CustomUserInfoException extends RuntimeException {
    public CustomUserInfoException(String errorMessage) {
        super(errorMessage);
    }
}
