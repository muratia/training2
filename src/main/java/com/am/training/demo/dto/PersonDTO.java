package com.am.training.demo.dto;

public class PersonDTO {

    private Long id;
    private String name;
    private String lastName;
    private String zipCode;
    private String city;
    private String color;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String name, String lastName, String zipCode, String city, String zipCode1, String color) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.city = city;
        this.zipCode = zipCode1;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
