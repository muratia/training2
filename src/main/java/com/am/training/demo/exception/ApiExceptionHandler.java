package com.am.training.demo.exception;

import com.am.training.demo.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ApiException.class,
            ColorNotFoundException.class,
            NoPersonsException.class,
            EmptyListException.class,
            PersonNotFoundException.class
    })
    public ResponseEntity<Object> handleResponseException(ApiException e) {
        ErrorDTO errorDTO = new ErrorDTO(e.getMessage(), new Date());
        return new ResponseEntity<> (errorDTO, e.getHttpStatus());
    }
}
