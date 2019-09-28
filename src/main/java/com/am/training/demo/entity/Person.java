package com.am.training.demo.entity;

import com.am.training.demo.utils.ColorHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "persons")
@JsonPropertyOrder({"id", "name", "lastname", "zipcode", "city", "color"})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonPropertyOrder()
    private Long id;

    @Column(name = "name", length = 150)
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "lastname")
    private String lastName;
    @JsonProperty(value = "zipcode")
    private String zipCode;
    private String city;
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Integer color;

    @Transient
    private ColorHandler colorHandler;

    public Person() {
        colorHandler = new ColorHandler ();
    }

    public Person(Long id, String name, String lastName, String zipCode, String city) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Person(Long id, String name, String lastName, String zipCode, String city, Integer color) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    @JsonProperty("color")
    public String getColorName() {
        return this.colorHandler.getColors ().get (this.color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals (getColor (), person.getColor ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getColor ());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", color=" + color +
                ", colorHandler=" + colorHandler +
                '}';
    }
}