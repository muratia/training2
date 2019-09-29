package com.am.training.demo.service;

import com.am.training.demo.entity.Language;
import com.am.training.demo.exception.LanguageNotFoundException;

public interface LanguageService {


     Language find(Integer id) throws LanguageNotFoundException;

}
