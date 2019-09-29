package com.am.training.demo.repository;


import com.am.training.demo.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Table;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
