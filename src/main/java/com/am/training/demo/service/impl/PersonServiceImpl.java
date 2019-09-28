package com.am.training.demo.service.impl;

import com.am.training.demo.dto.PersonDTO;
import com.am.training.demo.entity.Person;
import com.am.training.demo.exception.ColorNotFoundException;
import com.am.training.demo.exception.EmptyListException;
import com.am.training.demo.exception.NoPersonsException;
import com.am.training.demo.exception.PersonNotFoundException;
import com.am.training.demo.repository.PersonRepository;
import com.am.training.demo.service.PersonService;
import com.am.training.demo.utils.ColorHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final Logger logger = LoggerFactory.getLogger (PersonServiceImpl.class);

    private   PersonRepository repository;

    private final ColorHandler colorHandler;


    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
        this.colorHandler = new ColorHandler ();

    }


    @Override
    public Person find(Long id) throws PersonNotFoundException{
        Assert.isTrue( id != null, "id must not be null");
        //if(id == null) throw new IllegalArgumentException("Illegal parameter");
        Person person = repository.findById(id).orElse(null);
        if (person == null) throw new PersonNotFoundException("Person not found");
        return person;
    }

    @Override
    public Person save(Person person) {
        return this.repository.save (person);
    }

    @Override
    public List<Person> findPersons()  {
        return repository.findAll();
    }

    @Override
    public List<Person> findByColor(Integer color)  {
        return this.repository.findByColor (color);
    }

    @Override
    public List<Person> findByColorName(String colorName) throws ColorNotFoundException, NoPersonsException {
        if( ! colorHandler.getColorNames().containsKey(colorName)){
            logger.debug("Color not found " + colorName);
            throw new ColorNotFoundException("The passed color cannot be found! Check the color and please try again!");
        }
        List<Person> persons = this.repository.findByColor(this.colorHandler.getColorNames().get(colorName));
        if(persons.isEmpty()){
            throw new NoPersonsException("There are no entities");
        }
        return this.repository.findByColor (this.colorHandler.getColorNames ().get (colorName));
    }

    @Override
    public List<Person> save(List<Person> persons)  throws EmptyListException {
        logger.error ("List of Persons: " + persons);
        if (persons.isEmpty ()) throw new EmptyListException ("The list is empty");
        return this.repository.saveAll (persons);
    }
}
