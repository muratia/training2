package com.am.training.demo.exception;

public class PersonNotFoundException extends  Exception {

    public PersonNotFoundException(String message) {
        super (message);
    }

    public PersonNotFoundException(String message, Throwable cause) {
        super (message, cause);
    }
}
