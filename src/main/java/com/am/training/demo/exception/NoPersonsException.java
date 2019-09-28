package com.am.training.demo.exception;

public class NoPersonsException extends RuntimeException {

    public NoPersonsException(String message) {
        super (message);
    }

    public NoPersonsException(String message, Throwable cause) {
        super (message, cause);
    }
}
