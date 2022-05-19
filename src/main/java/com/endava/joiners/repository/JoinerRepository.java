package com.endava.joiners.repository;

import com.endava.joiners.model.Joiner;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface JoinerRepository extends JpaRepository<Joiner, Integer> {
    List<Joiner> findByStack(String stack);
    List<Joiner> findByRole(String role);
    List<Joiner> findByEnglishLevel(String englishLevel);
    List<Joiner> findByDomainExperience(String domainExperience);
}

