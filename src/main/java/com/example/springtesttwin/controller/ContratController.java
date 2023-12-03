package com.example.springtesttwin.controller;

import com.example.springtesttwin.entities.Contrat;
import com.example.springtesttwin.services.ContratBenificiareService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("contrat")
@Slf4j
public class ContratController {

    final ContratBenificiareService contratBenificiareService;

    @PostMapping("/ajouter")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratBenificiareService.ajouterContrat(contrat);
    }


}
