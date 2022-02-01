package com.smarthome.server.exception;

public class UnauthorizedException extends IllegalStateException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
