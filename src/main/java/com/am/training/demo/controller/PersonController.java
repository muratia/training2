package com.am.training.demo.controller;

import com.am.training.demo.dto.PersonDTO;
import com.am.training.demo.entity.Person;
import com.am.training.demo.exception.*;
import com.am.training.demo.processor.CvsProcessor;
import com.am.training.demo.service.PersonService;
import com.am.training.demo.util.mapper.PersonMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @SuppressWarnings("SpellCheckingInspection")
    @PostMapping(value = "", produces = "application/json")
    public List<Person> initializDb() throws IOException, EmptyListException {
        CvsProcessor cvsProcessor = new CvsProcessor();
        final String fileName = "data.csv";

        File file = new ClassPathResource(fileName).getFile();

        List<Person> persons = CvsProcessor.read(file.getPath());
        return personService.save(persons);
    }

    @GetMapping(value = "", produces = "application/json")
    public List<PersonDTO> getPersons() throws NoPersonsException {
        List<Person> persons = personService.findPersons();

        List<PersonDTO> personDTOS = new ArrayList<>();


        if (persons.isEmpty()) {
            throw new NoPersonsException("No persons were found");
        }
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(persons, personDTOS);
        for (Person p: persons) {
            personDTOS.add(PersonMapper.toDTO(p));
        }
        return personDTOS;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    public PersonDTO searchById(@PathVariable Long id) throws ApiException {
       try {
            Person person = personService.find(id);
            return PersonMapper.toDTO(person);
        }catch (IllegalArgumentException ieaex){
            throw new ApiException(ieaex.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (PersonNotFoundException pnfe){
            throw new ApiException(pnfe.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception ex) {
            throw new ApiException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("color/{color}")
    public List<PersonDTO> searchByColor(@PathVariable String color) throws ApiException {
        try {
            return PersonMapper.toDTOList(personService.findByColorName(color));
        } catch (NoPersonsException e) {
            throw new ApiException(e.getMessage(), HttpStatus.NO_CONTENT);
        } catch (ColorNotFoundException e) {
            throw new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("email/{email}")
    public List<PersonDTO> searchByEmail(@PathVariable String email) throws ApiException {
        try {
            return PersonMapper.toDTOList(personService.findByEmail(email));
        } catch (NoPersonsException e) {

            throw new ApiException(e.getMessage(), HttpStatus.NO_CONTENT);
        }
    }


}
