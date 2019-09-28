package com.am.training.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {
            ApiRequestException.class,

            NoPersonsException.class,
            EmptyListException.class
    })
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        // 1. Create a payload the api exception details
        HttpStatus badRequest = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException (
                e.getMessage (),
                badRequest,
                ZonedDateTime.now (ZoneId.of ("Z")));
        // 2. return response entity
        return new ResponseEntity<> (apiException, badRequest);
    }

    @ExceptionHandler(value
            = {  PersonNotFoundException.class, IllegalArgumentException.class, IllegalStateException.class,ColorNotFoundException.class  })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


}
