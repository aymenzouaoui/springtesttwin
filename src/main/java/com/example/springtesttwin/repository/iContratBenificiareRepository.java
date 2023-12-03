package com.example.springtesttwin.repository;

import com.example.springtesttwin.entities.Contrat;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;

public interface iContratBenificiareRepository extends CrudRepository<Contrat,Integer> {
    Contrat findByMatricule(String matricule);
}
