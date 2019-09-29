package com.am.training.demo.repository;

import com.am.training.demo.entity.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialNetworksRepository extends JpaRepository<SocialNetwork, Long> {
}
