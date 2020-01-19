package com.am.training.demo.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrorDTO {

    private final String message;
    private final String date;

    /**
     * Constructor of ErrorDTO
     *
     * @param message Message
     * @param date    Date
     */
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
