package com.am.training.demo.entity;

import com.am.training.demo.util.ColorHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *  Class class serves as a entity for the Person
 */

@Entity
@Table(name = "persons", uniqueConstraints=@UniqueConstraint(columnNames={"email"}))
@JsonPropertyOrder({"id", "name", "lastname", "zipcode", "city", "color"})
@Subselect("select p.id,p.city,p.color,p.dob,p.email,p.lastName,p.name,p.nativeLanguage_id,p.zipCode,(TIMESTAMPDIFF(YEAR, IFNULL(p.dob,CURDATE()) , CURDATE())) as age from  persons p")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonPropertyOrder()

    @JsonIgnore
    private Long id;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "lastName", length = 150)
    private String lastName;

    @Temporal(value = TemporalType.DATE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Date dob;

    private Integer age;

    @Column(name = "zipCode", length = 12)
    private String zipCode;

    @Column(name = "city", length = 150)
    private String city;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private Integer color;

    @Column( name="email",   updatable =  false)
    private String email;

    @Transient
    private ColorHandler colorHandler;

    @OneToMany
    private List<SocialNetwork> socialNetworks;

    @OneToOne
    private Language nativeLanguage;

    @OneToMany
    private List<Language> otherLanguages;

    /**
     *  Empty constructor
     */
    public Person() {
        // initialization of the ColorHandler @see ColorHandler
        colorHandler = new ColorHandler ();
    }


    /**
     * Constructor of the class
     * @param id Id of the tuple
     * @param name First name
     * @param lastName last name
     * @param zipCode Zip Code
     * @param city City
     */
    public Person(Long id, String name, String lastName, String zipCode, String city) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.city = city;
    }

    /**
     *  Constructor of the class
     * @param id Id of the tuple
     * @param name First name
     * @param lastName Last name
     * @param zipCode Zip code
     * @param city City
     * @param color Color
     */
    public Person(Long id, String name, String lastName, String zipCode, String city, Integer color) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.city = city;
        this.color = color;
    }

    /**
     * Constructor of the class
     * @param id Id of the tuple
     * @param name First name
     * @param lastName Last name
     * @param zipCode Zip code
     * @param city City
     * @param color Color
     * @param email E-mail
     */
    public Person(Long id, String name, String lastName, String zipCode, String city, Integer color, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.city = city;
        this.color = color;
        this.email = email;
    }

    /**
     *  Constructor of the class
     * @param id Id of the tuple
     * @param name First name
     * @param lastName Last name
     * @param dob Date of birth
     * @param zipCode Zip Code
     * @param city City
     * @param color Color
     * @param email E-mail
     */
    public Person(Long id, String name, String lastName,
                  Date dob, String zipCode, String city, Integer color, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dob = dob;
        this.zipCode = zipCode;
        this.city = city;
        this.color = color;
        this.email = email;
    }

    /**
     *  Constructor of the class
     * @param id Id of the tuple
     * @param name First name
     * @param lastName Last name
     * @param dob Date of birth
     * @param age Age
     * @param zipCode Zip code
     * @param city City
     * @param color Color
     * @param email E-mail
     */
    public Person(Long id, String name, String lastName, Date dob, Integer age, String zipCode, String city,
                  Integer color, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dob = dob;
        this.age = age;
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

    protected Integer getColor() {
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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