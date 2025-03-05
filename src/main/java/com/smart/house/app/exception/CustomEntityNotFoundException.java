package com.smart.house.app.exception;

import java.io.IOException;

public class CustomEntityNotFoundException extends IOException {

    public CustomEntityNotFoundException(String message) {
        super(message);
    }
}
