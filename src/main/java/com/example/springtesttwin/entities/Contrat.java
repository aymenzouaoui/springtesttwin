package com.example.springtesttwin.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contrat {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer  idContrat;

    String matricule;
    Date dateEffet;
    TypeContrat type;

}
