package com.kaci.blogspring0505.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kaci.blogspring0505.entities.Compte;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICompteRepository extends JpaRepository<Compte, Long> {

    //READ
    //Recherche le compte d'un article
    //Compte findById(2L).orElse(null);
    Compte findCompteByIdCompte(Long idCompte);

//@Transactional
    @Query("SELECT a.pseudo FROM Compte a, Article b WHERE b.idArticle=a.idCompte AND b.idArticle=1")
    List<Compte> pseudoCompte(@Param("x") Long idCompte);
    @Query("SELECT a FROM Compte a WHERE a.valide= false")
    List<Compte> listeComptesNonValide();

    //@Query("SELECT a.pseudo FROM Compte a WHERE a.valide=true And a.idCompte=21")
    //List<String> listeCompteValide();
}


