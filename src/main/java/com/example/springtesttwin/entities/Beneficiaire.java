package com.example.springtesttwin.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Beneficiaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idBenef;
    Integer cin;
    String nom;
    String prenom;
    String profession;
    Double salaire;

    @OneToMany(cascade =CascadeType.ALL,mappedBy = "beneficiaire")
    Set<Assurence>  assurences;
}
