package com.am.training.demo.service.impl;

import com.am.training.demo.entity.Language;
import com.am.training.demo.exception.LanguageNotFoundException;
import com.am.training.demo.repository.LanguageRepository;
import com.am.training.demo.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository repo;

    public LanguageServiceImpl(){

    }

    @Override
    public Language find(Integer id) throws LanguageNotFoundException {
        Assert.isTrue( id != null, "Id must not be null");
        Language language = repo.findById(id).orElse(null);
        if (language == null) throw new LanguageNotFoundException("Language not found");
        return language;
    }

}
