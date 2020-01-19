package com.am.training.demo.dto;

import java.time.LocalDate;

public class DataRowDTO {

    private String redner;

    private String thema;

    private LocalDate datum;

    private Integer woerter;

    public DataRowDTO(String redner, String thema, LocalDate datum, Integer woerter) {
        this.redner = redner;
        this.thema = thema;
        this.datum = datum;
        this.woerter = woerter;
    }

    public String getRedner() {
        return redner;
    }

    public void setRedner(String redner) {
        this.redner = redner;
    }

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Integer getWoerter() {
        return woerter;
    }

    public void setWoerter(Integer woerter) {
        this.woerter = woerter;
    }
}
