package com.example.springtesttwin.controller;

import com.example.springtesttwin.entities.Beneficiaire;
import com.example.springtesttwin.entities.TypeContrat;
import com.example.springtesttwin.services.BeneficiaireeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.Set;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("beneficiaire")
@Slf4j
public class BeneficiaireController {

    final BeneficiaireeService beneficiaireeService;

    @PostMapping("/ajouter")
    public Beneficiaire ajouterBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
        System.out.println("test boncourage");
        return beneficiaireeService.ajouterBeneficiaire(beneficiaire);
    }

    @GetMapping("/montant/{cin}")
    public Set<Beneficiaire> getMontantByType(@PathVariable int cin) {
        return beneficiaireeService.getBeneficairesByType(TypeContrat.Mensuel); // Change TypeContrat as needed
    }
}
