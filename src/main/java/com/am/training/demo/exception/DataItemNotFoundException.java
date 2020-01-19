package com.am.training.demo.exception;

public class DataItemNotFoundException extends Exception {
    public DataItemNotFoundException(String data_not_found_) {
        super(data_not_found_);
    }
}
