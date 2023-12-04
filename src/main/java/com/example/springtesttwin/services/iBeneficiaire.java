package com.example.springtesttwin.services;

import com.example.springtesttwin.entities.Beneficiaire;
import com.example.springtesttwin.entities.TypeContrat;

import java.util.Set;

public interface iBeneficiaire {
    Beneficiaire ajouterBeneficiaire (Beneficiaire bf) ;

    public Set<Beneficiaire> getBeneficairesByType (TypeContrat typeContrat);

    Set<Beneficiaire> getBeneficiairesByType(TypeContrat typeContrat);

}
