package com.am.training.demo.service;

import com.am.training.demo.entity.Person;
import com.am.training.demo.entity.SocialNetwork;
import com.am.training.demo.exception.SocialNetworkNotFoundException;

import java.util.List;

public interface SocialNetworkService {

    SocialNetwork find(Long id) throws SocialNetworkNotFoundException;

    List<SocialNetwork> loadAll();


}
