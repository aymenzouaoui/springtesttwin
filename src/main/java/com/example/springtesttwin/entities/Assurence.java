package com.example.springtesttwin.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Assurence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer  idAssurence;
    String designation ;
    float montant;
    @ManyToOne(cascade = CascadeType.ALL)
    Contrat contrat;

    @ManyToOne
    Beneficiaire beneficiaire;
}
