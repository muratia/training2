package com.am.training.demo.service.impl;

import com.am.training.demo.entity.Person;
import com.am.training.demo.exception.ColorNotFoundException;
import com.am.training.demo.exception.EmptyListException;
import com.am.training.demo.exception.NoPersonsException;
import com.am.training.demo.exception.PersonNotFoundException;
import com.am.training.demo.repository.PersonRepository;
import com.am.training.demo.service.PersonService;
import com.am.training.demo.utils.ColorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Optional<Person> find(Long id)  {


        return repository.findById(id);
    }

    @Override
    public Person save(Person person) {
        return this.repository.save (person);
    }

    @Override
    public List<Person> findPersons() throws NoPersonsException {
        List<Person> people = this.repository.findAll ();
        if (people.size () == 0) throw new NoPersonsException ("There are no persons on the database");
        return people;
    }

    @Override
    public List<Person> findByColor(Integer color)  {

        return this.repository.findByColor (color);
    }

    @Override
    public List<Person> findByColorName(String colorName) {


        Integer colorId = this.colorHandler.getColorNames ().get (colorName);


        return this.repository.findByColor (colorId);
    }

    @Override
    public List<Person> save(List<Person> persons)  {
        logger.error ("List of Persons: " + persons);
        if (persons.isEmpty ()) throw new EmptyListException ("The list is empty");
        return this.repository.saveAll (persons);
    }
}
