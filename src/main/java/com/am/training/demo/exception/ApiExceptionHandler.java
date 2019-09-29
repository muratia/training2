package com.am.training.demo.exception;

import com.am.training.demo.controller.PersonController;
import com.am.training.demo.dto.ErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);


    @ExceptionHandler(value = { ApiException.class })
    public ResponseEntity<Object> handleResponseException(ApiException e) {
        ErrorDTO errorDTO = new ErrorDTO(e.getMessage(), new Date());
        LOGGER.error(e.getMessage());
        return new ResponseEntity<> (errorDTO, e.getHttpStatus());
    }
}
