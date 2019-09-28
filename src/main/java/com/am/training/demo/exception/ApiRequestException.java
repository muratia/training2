package com.am.training.demo.exception;

public class ApiRequestException extends RuntimeException {

    @SuppressWarnings("unused")
    public ApiRequestException(String message) {
        super (message);
    }

    @SuppressWarnings("unused")
    public ApiRequestException(String message, Throwable cause) {
        super (message, cause);
    }
}
