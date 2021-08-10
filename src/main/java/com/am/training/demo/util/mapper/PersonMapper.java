package com.am.training.demo.util.mapper;

import com.am.training.demo.dto.PersonDTO;
import com.am.training.demo.entity.Person;
import com.am.training.demo.util.ColorHandler;

import java.util.ArrayList;
import java.util.List;

/**
 *  PersonMapper is a class that converts Person into PersonDTO and vice versa, and List<Person> into List<PersonDTO> and vice versa
 */
public class PersonMapper {

    /**
     * Constructor of the class
     */
    private PersonMapper() {

    }

    /**
     * The method converts a parameter Person domain entity into PersonDTO
     * @param person Person Domain Entity
     * @return PersonDTO
     */
    public static PersonDTO toDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setLastName(person.getLastName());
        personDTO.setZipCode(person.getZipCode());
        personDTO.setCity(person.getCity());
        personDTO.setColor(person.getColorName());
        personDTO.setEmail(person.getEmail());
        personDTO.setSocialNetworks(person.getSocialNetworks());
        personDTO.setNativeLanguage(person.getNativeLanguage());
        personDTO.setOtherLanguages(person.getOtherLanguages());
        personDTO.setAge(person.getAge());
        return personDTO;
    }

    /**
     * The method converts the parameter PersonDTO into Person domain entity
     * @param personDTO Parameter PersonDTO
     * @return Person Domain Entity
     */
    public static Person toEntity(PersonDTO personDTO) {
        Person person = new Person();
        ColorHandler colorHandler = new ColorHandler();
        person.setId(personDTO.getId());
        person.setName(personDTO.getName());
        person.setLastName(personDTO.getLastName());
        person.setZipCode(personDTO.getZipCode());
        person.setCity(personDTO.getCity());
        Integer color = colorHandler.getColorNames().get(personDTO.getColor());
        person.setColor(color);
        person.setEmail(personDTO.getEmail());
        person.setSocialNetworks(personDTO.getSocialNetworks());
        person.setNativeLanguage(personDTO.getNativeLanguage());
        person.setOtherLanguages(personDTO.getOtherLanguages());
        return person;
    }

    /**
     *  The method converts the parameter List<Person> into List<PersonDTO>
     * @param personList List of Person entities parameter
     * @return List of List<PersonDTO>
     */
    public static List<PersonDTO> toDTOList(List<Person> personList) {
        List<PersonDTO> personDTOS = new ArrayList<>();
        for (Person person : personList) {
            personDTOS.add(PersonMapper.toDTO(person));
        }
        return personDTOS;
    }

    /**
     * Converts the parameter list<PersonDTO> into List<Person>
     * @param personDTOS List of PersonDTO parameter
     * @return List<Person>
     */
    public static List<Person> toEntityList(List<PersonDTO> personDTOS){
        List<Person> personList = new ArrayList<>();
        for(PersonDTO personDTO: personDTOS){
            personList.add(PersonMapper.toEntity(personDTO));
        }
        return personList;
    }
}
