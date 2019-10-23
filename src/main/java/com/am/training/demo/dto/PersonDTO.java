package com.am.training.demo.dto;

import com.am.training.demo.entity.Language;
import com.am.training.demo.entity.SocialNetwork;

import java.util.List;

public class PersonDTO {

    private Long id;
    private String name;
    private String lastName;
    private String zipCode;
    private String city;
    private String color;
    private String email;
    private Integer age;
    private List<SocialNetwork> socialNetworks;
    private Language nativeLanguage;
    private List<Language> otherLanguages;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String name, String lastName, String zipCode, String city, String color) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.city = city;
        this.color = color;
    }

    public PersonDTO(Long id, String name, String lastName, String zipCode, String city, String color, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.city = city;
        this.color = color;
        this.email = email;
    }

    public PersonDTO(Long id, String name, String lastName, String zipCode, String city, String color, String email, List<SocialNetwork> socialNetworks, Language nativeLanguage, List<Language> otherLanguages) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.city = city;
        this.color = color;
        this.email = email;
        this.socialNetworks = socialNetworks;
        this.nativeLanguage = nativeLanguage;
        this.otherLanguages = otherLanguages;
    }

    public PersonDTO(Long id, String name, String lastName, String zipCode, String city, String color, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.city = city;
        this.color = color;
        this.email = email;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
