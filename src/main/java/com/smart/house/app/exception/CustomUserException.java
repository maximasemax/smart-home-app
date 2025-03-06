package com.smart.house.app.exception;

import java.io.IOException;

public class CustomUserException extends IOException {

  public CustomUserException(String message) {
    super(message);
  }
}
