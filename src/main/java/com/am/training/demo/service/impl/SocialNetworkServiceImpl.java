package com.am.training.demo.service.impl;

import com.am.training.demo.entity.Language;
import com.am.training.demo.entity.Person;
import com.am.training.demo.entity.SocialNetwork;
import com.am.training.demo.exception.LanguageNotFoundException;
import com.am.training.demo.exception.SocialNetworkNotFoundException;
import com.am.training.demo.repository.SocialNetworksRepository;
import com.am.training.demo.service.SocialNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class SocialNetworkServiceImpl implements SocialNetworkService {

    @Autowired
    private SocialNetworksRepository repo;

    public SocialNetwork find(Long id) throws SocialNetworkNotFoundException {
        Assert.isTrue( id != null, "Id must not be null");
        SocialNetwork socialNetwork = repo.findById(id).orElse(null);
        if (socialNetwork == null) throw new SocialNetworkNotFoundException("Social network not found");
        return socialNetwork;
    }

    @Override
    public List<SocialNetwork> loadAll() {
        return repo.findAll();
    }


}
