package com.am.training.demo.controller;

import com.am.training.demo.entity.Person;
import com.am.training.demo.exception.ColorNotFoundException;
import com.am.training.demo.exception.NoPersonsException;
import com.am.training.demo.exception.PersonNotFoundException;
import com.am.training.demo.processor.CvsProcessor;
import com.am.training.demo.service.PersonService;
import com.am.training.demo.utils.ColorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("persons")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @SuppressWarnings("SpellCheckingInspection")
    @PostMapping(value = "", produces = "application/json")
    public List<Person> initializDb() throws IOException {
        CvsProcessor cvsProcessor = new CvsProcessor();
        final String fileName = "data.csv";

        File file = new ClassPathResource(fileName).getFile();

        List<Person> persons = CvsProcessor.read(file.getPath());
        return personService.save(persons);
    }

    @GetMapping(value = "", produces = "application/json")
    public List<Person> getPersons() throws NoPersonsException {

        return personService.findPersons();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    public Person searchById(@PathVariable Long id) throws PersonNotFoundException {
        Optional<Person> personO = personService.find(id);
        Person person = new Person();
        try {
            return personO.get();
        } catch (Exception ex) {
            throw new PersonNotFoundException("Person not found");
        }
    }

    @GetMapping("color/{color}")
    public List<Person> searchByColor(@PathVariable String color) throws NoPersonsException,  ColorNotFoundException {
        ColorHandler colorHandler = new ColorHandler();

       if( ! colorHandler.getColorNames().containsKey(color)){
           logger.debug("Color not found " + color);
           throw new ColorNotFoundException("The passed color cannot be found! Check the color and please try again!");
       }else {
           logger.info("Color found");
           return personService.findByColorName(color);
       }
    }
}
