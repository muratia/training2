package com.am.training.demo.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    @Before
    public void before() {
        Person p = new Person ();

    }

    @Test
    public void getId() {
        Long id = 13L;
        Person person = new Person (id, "Ahmet", "Murati", "82467", "Garmisch-Partenkichen", 1);
        assertEquals (id, person.getId ());

    }

    @Test
    public void setId() {

        Long id = 14L;
        Person person = new Person ();
        person.setId (id);
        assertEquals (id, person.getId ());
    }

    @Test
    public void getName() {
        String name = "Ahmet";
        Person person = new Person (0L, "Ahmet", "Murati", "82467", "Garmisch-Partenkichen", 1);
        assertEquals (name, person.getName ());
    }

    @Test
    public void setName() {
        String name = "Ahmet";
        Person person = new Person ();
        person.setName (name);
        assertEquals (name, person.getName ());
    }

    @Test
    public void getLastName() {
        String name = "Murati";
        Person person = new Person (0L, "Ahmet", "Murati", "82467", "Garmisch-Partenkichen", 1);
        assertEquals (name, person.getLastName ());
    }

    @Test
    public void setLastName() {
        String lastName = "Murati";
        Person person = new Person ();
        person.setLastName (lastName);
        assertEquals (lastName, person.getLastName ());
    }

    @Test
    public void getZipCode() {
        String zipCode = "82467";

        Person person = new Person (0L, "Ahmet", "Murati", "82467", "Garmisch-Partenkichen", 1);

        assertEquals (zipCode, person.getZipCode ());
    }

    @Test
    public void setZipCode() {
        String zipCode = "82467";

        Person person = new Person (0L, "Ahmet", "Murati", zipCode, "Garmisch-Partenkichen", 1);
        person.setZipCode (zipCode);
        assertEquals (zipCode, person.getZipCode ());
    }

    @Test
    public void getColor() {
        Integer color = 1;
        Person person = new Person (0L, "Ahmet", "Murati", "82467", "Garmisch-Partenkichen", color);
        assertEquals (color, person.getColor ());
    }

    @Test
    public void setColor() {
        Integer color = 1;
        Person person = new Person ();
        person.setColor (color);
        assertEquals (color, person.getColor ());
    }
}