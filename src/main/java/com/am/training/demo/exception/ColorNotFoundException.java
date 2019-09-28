package com.am.training.demo.exception;

@SuppressWarnings("unused")
public class ColorNotFoundException extends  Exception {

    public ColorNotFoundException() {
    }

    public ColorNotFoundException(String message) {
        super (message);
    }

    public ColorNotFoundException(String message, Throwable cause) {
        super (message, cause);
    }
}
