package com.handlersAndExceptions;

import java.io.IOException;

public class CustomException extends IOException {
    public CustomException(String message) {
        super(message);
    }
}