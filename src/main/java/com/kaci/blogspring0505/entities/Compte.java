package com.kaci.blogspring0505.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;
    private String email;
    @Column(name = "COMPTE_PSEUDO", unique = true)
    private String pseudo;
    private String motDePasse;
    private boolean efface;
    private boolean bani;
    private boolean valide;
    private boolean supressionDonnee;
    private boolean signale;

    @ManyToMany(mappedBy = "compte", fetch = FetchType.EAGER)
    private List<TypeCompte> typeCompte = new ArrayList<>();
}
