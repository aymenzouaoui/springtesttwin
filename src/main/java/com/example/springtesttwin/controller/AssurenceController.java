package com.example.springtesttwin.controller;

import com.example.springtesttwin.entities.Assurence;
import com.example.springtesttwin.services.AssurenceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("assurance")
@Slf4j
public class AssurenceController {

    final AssurenceService assurenceService;

    @PostMapping("/ajouter")
    public Assurence ajouterAssurance(@RequestBody Assurence assurance, @RequestParam int cinBf, @RequestParam String matricule) {
        return assurenceService.ajouterAssurance(assurance, cinBf, matricule);
    }

    // Add more methods as needed, e.g., to retrieve information about assurances
}
