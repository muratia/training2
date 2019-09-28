package com.am.training.demo.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrorDTO {
    private String message;
    private String date;

    public ErrorDTO(String message, Date date) {
        this.message = message;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        this.date = simpleDateFormat.format(date);
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }
}
