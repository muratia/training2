package com.am.training.demo.controller;

import com.am.training.demo.entity.Language;
import com.am.training.demo.exception.LanguageNotFoundException;
import com.am.training.demo.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="languages")
public class LanguageController {

    private final LanguageService service;

    public LanguageController(LanguageService languageService ){
        this.service = languageService;
    }

    @GetMapping("{id}")
    public Language findById(@PathVariable Integer id) throws LanguageNotFoundException {
        return service.find(id);
    }
}
