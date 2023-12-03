package com.example.springtesttwin.services;

import com.example.springtesttwin.entities.Contrat;
import com.example.springtesttwin.entities.TypeContrat;
import com.example.springtesttwin.repository.iContratBenificiareRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class ContratBenificiareService implements iContrat {

private final iContratBenificiareRepository contratBenificiareRepository;

    @Override
    public Contrat ajouterContrat(Contrat c) {
        return contratBenificiareRepository.save(c);
    }
}
