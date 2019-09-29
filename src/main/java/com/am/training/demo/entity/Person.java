package com.am.training.demo.entity;

import com.am.training.demo.dto.PersonDTO;
import com.am.training.demo.utils.ColorHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "persons", uniqueConstraints=@UniqueConstraint(columnNames={"email"}))
@JsonPropertyOrder({"id", "name", "lastname", "zipcode", "city", "color"})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonPropertyOrder()

    @JsonIgnore private Long id;

    @Column(name = "name", length = 150)
    private String name;
    @Column(name = "lastName", length = 150)
    private String lastName;
    @Column(name = "zipCode", length = 12)
    private String zipCode;
    @Column(name = "city", length = 150)
    private String city;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Integer color;
    @Column( name="email",  insertable = true, updatable =  false)
    private String email;

    @Transient
    private ColorHandler colorHandler;

    @OneToMany
    private List<SocialNetwork> socialNetworks;

    @OneToOne
    private Language nativeLanguage;

    @OneToMany
    private List<Language> otherLanguages;

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

    public Person(Long id, String name, String lastName, String zipCode, String city, Integer color, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.city = city;
        this.color = color;
        this.email = email;
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

    public String getColorName() {
        return this.colorHandler.getColors ().get (this.color);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SocialNetwork> getSocialNetworks() {
        return socialNetworks;
    }

    public void setSocialNetworks(List<SocialNetwork> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    public Language getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(Language nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public List<Language> getOtherLanguages() {
        return otherLanguages;
    }

    public void setOtherLanguages(List<Language> otherLanguages) {
        this.otherLanguages = otherLanguages;
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

    public PersonDTO toPersonDTO(){
        PersonDTO personDTO = new PersonDTO();

        personDTO.setId(this.getId());
        personDTO.setName(this.getName());
        personDTO.setLastName(this.getLastName());
        personDTO.setZipCode(this.getZipCode());
        personDTO.setCity(this.getCity());
        personDTO.setColor(this.getColorName());
        personDTO.setEmail(this.getEmail());
        personDTO.setSocialNetworks(this.getSocialNetworks());
        personDTO.setNativeLanguage(this.getNativeLanguage());
        personDTO.setOtherLanguages(this.getOtherLanguages());
        return personDTO;
    }
}