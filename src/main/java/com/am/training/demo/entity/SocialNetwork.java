package com.am.training.demo.entity;

import javax.persistence.*;


@Entity
@Table(name= "socialnetworks")
public class SocialNetwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="url", unique = true)
    private String url;

    public Boolean active;

    public SocialNetwork(){

    }

    public SocialNetwork(Long id, String url, Boolean active) {
        this.id = id;
        this.url = url;
        this.active = active;
    }

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}