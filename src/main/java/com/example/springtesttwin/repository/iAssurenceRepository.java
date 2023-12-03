package com.example.springtesttwin.repository;

import com.example.springtesttwin.entities.Assurence;
import com.example.springtesttwin.entities.Beneficiaire;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface iAssurenceRepository extends CrudRepository<Assurence,Integer> {

    List<Assurence> findByBeneficiaire(Beneficiaire beneficiaire);
}
