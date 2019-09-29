package com.am.training.demo.util.mapper;

import com.am.training.demo.dto.PersonDTO;
import com.am.training.demo.entity.Person;
import com.am.training.demo.util.ColorHandler;

import java.util.ArrayList;
import java.util.List;

public class PersonMapper {

    private PersonMapper() {

    }

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
        return personDTO;
    }


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


    public static List<PersonDTO> toDTOList(List<Person> personList) {
        List<PersonDTO> personDTOS = new ArrayList<>();
        for (Person person : personList) {
            personDTOS.add(PersonMapper.toDTO(person));
        }
        return personDTOS;
    }
}
