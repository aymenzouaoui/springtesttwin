package com.example.springtesttwin.repository;

import com.example.springtesttwin.entities.Beneficiaire;
import com.example.springtesttwin.entities.TypeContrat;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface iBeneficiaireReository extends CrudRepository<Beneficiaire, Integer> {

Beneficiaire findByCin(Integer  cin);

    @Query("SELECT b FROM Beneficiaire b JOIN b.assurences a JOIN a.contrat c WHERE c.type = :type")
    Set<Beneficiaire> getBeneficiairesByType(@Param("type") TypeContrat type);


    @Query("SELECT c FROM Beneficiaire b " +
            "JOIN b.assurences a " +
            "JOIN a.contrat c " +
            "WHERE b.idBenef = :idBf " +
            "ORDER BY c.dateEffet ASC")
    Contrat getOldestContratForBeneficiaire(@Param("idBf") Integer idBf);

}
