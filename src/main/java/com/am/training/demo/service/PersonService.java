package com.am.training.demo.service;

import com.am.training.demo.entity.Person;
import com.am.training.demo.exception.ColorNotFoundException;
import com.am.training.demo.exception.EmptyListException;
import com.am.training.demo.exception.NoPersonsException;
import com.am.training.demo.exception.PersonNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Person find(Long id) throws PersonNotFoundException;

    Person save(Person person);

    List<Person> findPersons()  ;

    List<Person> findByColor(Integer color);

    List<Person> findByColorName(String color) throws ColorNotFoundException, NoPersonsException;

    List<Person> save(List<Person> persons) throws EmptyListException;

    List<Person> findByEmail(String email) throws NoPersonsException;
}
