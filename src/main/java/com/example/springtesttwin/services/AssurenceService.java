package com.example.springtesttwin.services;

import com.example.springtesttwin.entities.Assurence;
import com.example.springtesttwin.entities.Beneficiaire;
import com.example.springtesttwin.entities.Contrat;
import com.example.springtesttwin.entities.TypeContrat;
import com.example.springtesttwin.repository.iAssurenceRepository;
import com.example.springtesttwin.repository.iBeneficiaireReository;
import com.example.springtesttwin.repository.iContratBenificiareRepository;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    public float getMontantBf(int cinBf) {
        Beneficiaire beneficiaire = beneficiaireReository.findByCin(cinBf);

        if (beneficiaire != null) {
            List<Assurence> assurances = assurenceRepository.findByBeneficiaire(beneficiaire);

            float montantTotal = 0.0f;

            for (Assurence assurance : assurances) {
                montantTotal += calculateMontantAnnuel(assurance);
            }

            return montantTotal;
        }

        return 0.0f; // Return 0 if the beneficiary is not found
    }

    private float calculateMontantAnnuel(Assurence assurance) {
        if (assurance.getContrat().getType() == TypeContrat.Semestre) {
            return assurance.getMontant() * 2;
        } else if (assurance.getContrat().getType() == TypeContrat.Mensuel) {
            return assurance.getMontant() * 12; // Multiply by 12 for monthly
        }

        return assurance.getMontant(); // Return original amount for other contract types
    }




    @Scheduled(fixedRate = 60000) // Scheduled to run every 60 seconds
    public void statistiques() {
        Map<Integer, Integer> assuranceCountByBeneficiaire = new TreeMap<>(Collections.reverseOrder());

        // Fetch all assurances
        Iterable<Assurence> assurances = assurenceRepository.findAll();

        // Count assurances for each beneficiary
        for (Assurence assurance : assurances) {
            Beneficiaire beneficiaire = assurance.getBeneficiaire();
            int cin = beneficiaire.getCin();

            assuranceCountByBeneficiaire.merge(cin, 1, Integer::sum);
        }

        // Display the results
        System.out.println("Statistiques des assurances par bénéficiaire (ordre décroissant):");
        for (Map.Entry<Integer, Integer> entry : assuranceCountByBeneficiaire.entrySet()) {
            System.out.println("CIN: " + entry.getKey() + ", Nombre d'assurances: " + entry.getValue());
        }
    }
}
