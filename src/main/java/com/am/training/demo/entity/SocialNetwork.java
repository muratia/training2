package com.am.training.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * This class serves as entity SocialNetworks
 */
@Entity
@Table(name= "socialnetworks")
public class SocialNetwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="url", unique = true)
    private String url;

    private Boolean active;

    /**
     * Empty constructor
     */
    public SocialNetwork(){

    }


    /**
     *  Constructor of the class
     * @param id Id of the tuple
     * @param url URL of the social network
     * @param active Status of the social network
     */
    public SocialNetwork(Long id, String url, Boolean active) {
        this.id = id;
        this.url = url;
        this.active = active;
    }
    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
