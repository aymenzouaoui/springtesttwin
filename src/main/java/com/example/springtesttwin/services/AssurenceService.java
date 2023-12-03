package com.example.springtesttwin.services;

import com.example.springtesttwin.entities.Assurence;
import com.example.springtesttwin.entities.Beneficiaire;
import com.example.springtesttwin.entities.Contrat;
import com.example.springtesttwin.repository.iAssurenceRepository;
import com.example.springtesttwin.repository.iBeneficiaireReository;
import com.example.springtesttwin.repository.iContratBenificiareRepository;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AssurenceService implements iAssurenceService {
          private final iAssurenceRepository assurenceRepository;
    private final iBeneficiaireReository beneficiaireReository;
    private final iContratBenificiareRepository contratBenificiareRepository;
    @Override
    public Assurence ajouterAssurance(Assurence a, int cinBf, String matricule) {
     Beneficiaire b=beneficiaireReository.findByCin(cinBf);
        Contrat c =contratBenificiareRepository.findByMatricule(matricule);
        a.setBeneficiaire(b);
        a.setContrat(c);

        return assurenceRepository.save(a);
    }
}
