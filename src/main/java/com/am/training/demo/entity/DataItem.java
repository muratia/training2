package com.am.training.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Data row
 */
@Entity
@Table(catalog = "training3", name = "dataItem")
public class DataItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;


    @Transient
    private MultipartFile multiPartFile;

    @JsonProperty(value = "Redner")
    private String redner;
    @JsonProperty(value = "Thema")
    private String thema;
    @JsonProperty(value = "Datum")
    private LocalDate datum;
    @JsonProperty(value = "Wörter")
    private Integer woerter;

    public DataItem() {
    }

    /**
     * Konstruktor des Klase DataItem
     *
     * @param redner
     * @param thema
     * @param datum
     * @param woerter
     */
    public DataItem(Integer id, String redner, String thema, LocalDate datum, Integer woerter) {
        this.id = id;
        this.redner = redner;
        this.thema = thema;
        this.datum = datum;
        this.woerter = woerter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Bringst der Wert von Redner
     *
     * @return
     */
    public String getRedner() {
        return redner;
    }

    /**
     * Setzt den Redner
     *
     * @param redner String
     */
    public void setRedner(String redner) {
        this.redner = redner;
    }


    /**
     * Bringst der Wert von
     *
     * @return String
     */
    public String getThema() {
        return thema;
    }


    /**
     * Setzt den Thema
     *
     * @param thema
     */
    public void setThema(String thema) {
        this.thema = thema;
    }


    /**
     * Bringst den Wert von Datum
     *
     * @return
     */
    public LocalDate getDatum() {
        return datum;
    }


    /**
     * Setzt den Datum
     *
     * @param datum
     */
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Integer getWoerter() {
        return woerter;
    }

    public void setWoerter(Integer woerter) {
        this.woerter = woerter;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "id=" + id +
                ", redner='" + redner + '\'' +
                ", thema='" + thema + '\'' +
                ", datum=" + datum +
                ", woerter=" + woerter +
                '}';
    }

    public MultipartFile getMultiPartFile() {
        return multiPartFile;
    }

    public void setMultiPartFile(MultipartFile multiPartFile) {
        this.multiPartFile = multiPartFile;
    }
}
