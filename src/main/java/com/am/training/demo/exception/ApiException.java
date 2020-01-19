package com.am.training.demo.exception;

import org.springframework.http.HttpStatus;


/**
 * This class serves to capture ApiExceptions
 */
@SuppressWarnings("unused")
public class ApiException extends Exception {

    private final String message;

    private final HttpStatus httpStatus;


    /**
     * Constructor of the class
     *
     * @param message    Message
     * @param httpStatus HttpStatus
     */

    public ApiException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
