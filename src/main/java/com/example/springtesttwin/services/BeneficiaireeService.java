package com.example.springtesttwin.services;

import com.example.springtesttwin.entities.Beneficiaire;
import com.example.springtesttwin.entities.TypeContrat;
import com.example.springtesttwin.repository.iBeneficiaireReository;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Set;
@RequiredArgsConstructor
@Service

public class BeneficiaireeService implements iBeneficiaire {
    private final iBeneficiaireReository beneficiaireReository;

    @Override
    public Beneficiaire ajouterBeneficiaire(Beneficiaire bf) {
        return beneficiaireReository.save(bf);
    }

    @Override
    public Set<Beneficiaire> getBeneficairesByType(TypeContrat typeContrat) {
        return beneficiaireReository.getBeneficiairesByType(typeContrat);
    }


     @Override
    public Set<Beneficiaire> getBeneficairesByType(TypeContrat typeContrat) {
        return beneficiaireReository.getBeneficiairesByType(typeContrat);
    }
}
