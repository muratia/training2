package com.am.training.demo.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DataItemTest {

    private DataItem dataItem;
    @Test
    void getId() {
        Integer id = 9;
        String redner = "";
        String thema = "";
        LocalDate localDate = LocalDate.now();
        Integer woerter = 0;
        dataItem = new DataItem(id, redner, thema, LocalDate.now(), woerter);

        assertEquals(id, dataItem.getId());
    }
    @Test
    void setId() {
        Integer id = 7;
        String redner = "";
        String thema = "";
        LocalDate localDate = LocalDate.now();
        Integer woerter = 0;
        dataItem = new DataItem();
        dataItem.setId(id);

        assertEquals(id, dataItem.getId());
    }

    @Test
    void getRedner() {
        Integer id = 0;
        String redner = "Ahmet";
        String thema = "";
        LocalDate localDate = LocalDate.now();
        Integer woerter = 0;
        dataItem = new DataItem(id, redner, thema, LocalDate.now(), woerter);

        assertEquals(redner, dataItem.getRedner());
    }

    @Test
    void setRedner() {
        Integer id = 0;
        String redner = "ahmet";
        String thema = "";
        LocalDate localDate = LocalDate.now();
        Integer woerter = 0;
        dataItem = new DataItem();
        dataItem.setRedner(redner);

        assertEquals(redner, dataItem.getRedner());
    }

    @Test
    void getThema() {
        Integer id = 0;
        String redner = "";
        String thema = "Cybersecurity";
        LocalDate localDate = LocalDate.now();
        Integer woerter = 0;
        dataItem = new DataItem(id, redner, thema, LocalDate.now(), woerter);

        assertEquals(thema, dataItem.getThema());
    }

    @Test
    void setThema() {
        Integer id = 0;
        String redner = "";
        String thema = "Computer Security";
        LocalDate localDate = LocalDate.now();
        Integer woerter = 0;
        dataItem = new DataItem();
        dataItem.setThema(thema);

        assertEquals(thema, dataItem.getThema());
    }

    @Test
    void getDatum() {
        Integer id = 0;
        String redner = "";
        String thema = "";
        LocalDate localDate = LocalDate.now();
        Integer woerter = 0;
        dataItem = new DataItem(id, redner, thema, LocalDate.now(), woerter);

        assertEquals(localDate, dataItem.getDatum());
    }

    @Test
    void setDatum() {
        Integer id = 0;
        String redner = "";
        String thema = "Computer Security";
        LocalDate localDate = LocalDate.now();
        Integer woerter = 0;
        dataItem = new DataItem();
        dataItem.setDatum(localDate);

        assertEquals(localDate, dataItem.getDatum());
    }

    @Test
    void getWoerter() {
        Integer id = 0;
        String redner = "";
        String thema = "";
        LocalDate localDate = LocalDate.now();
        Integer woerter = 31;
        dataItem = new DataItem(id, redner, thema, LocalDate.now(), woerter);

        assertEquals(woerter, dataItem.getWoerter());
    }

    @Test
    void setWoerter() {
        Integer id = 0;
        String redner = "";
        String thema = "Computer Security";
        LocalDate localDate = LocalDate.now();
        Integer woerter = 0;
        dataItem = new DataItem();
        dataItem.setWoerter(woerter);

        assertEquals(woerter, dataItem.getWoerter());
    }
}