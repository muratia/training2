package com.am.training.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * This class serves as entity of languages
 */
@Entity
@Table(name="languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String title;

    private String description;

    /**
     *  Emtpy Constructor
     */
    public Language() {
    }

    /**
     *  Constructor of the class
     * @param id id of the tuple
     * @param title Title of the language
     * @param description Description of the language
     */
    public Language(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    @JsonIgnore
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonIgnore
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
