package com.kaci.blogspring0505.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaci.blogspring0505.entities.Article;
import com.kaci.blogspring0505.entities.Commentaire;

public interface ICommentaireRepository extends JpaRepository<Commentaire, Long> {
    // CREATE
    // Crée un commentaire d'un article
    // définie dans service

    // READ
    // liste des commentaires d'un article
    List<Commentaire> findCommentairesByArticle(Article article); // OK

    // Affiche UN commentaire
    Commentaire findCommentaireByIdCommentaire(Long idCommentaire);

    // Liste Commentaires publiques d'un article
    List<Commentaire> findCommentairesBy_publicIsTrueAndArticle(Article article);

    // liste des commentaires non encore modérés
    List<Commentaire> findCommentairesByModereIsFalse();
}
