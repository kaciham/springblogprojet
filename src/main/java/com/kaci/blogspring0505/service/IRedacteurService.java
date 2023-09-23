package com.kaci.blogspring0505.service;

import java.util.List;
import java.util.Optional;

import org.attoparser.dom.Comment;

import com.kaci.blogspring0505.entities.Article;
import com.kaci.blogspring0505.entities.Commentaire;
import com.kaci.blogspring0505.entities.Compte;

// création méthode rédacteur
public interface IRedacteurService {
    // CREATE
    Article creeArticle(Article article);

    // READ
    List<Article> listeArticle();

    Article afficheArticle(Long idArticle);

    // UPDATE
    Article modifieArticle(Article article, Long idArticle);

    // DELETE
    String supprimeArticle(Long idArticle);

    /* Commentaire */
    // CREATE
    // Crée un commentaire d'un article
    Commentaire creeCommentaire(Commentaire commentaire);

    // READ
    // Affiche les commentaires d'un article
    List<Commentaire> listeCommentairesArticle(Article article);

    // Affiche UN commentairex x²
    Commentaire afficheCommentaire(Long idCommentaire);

    // UPDATE
    // mettre un jour un commentaire
    Commentaire updateCommentaire(Commentaire commnentaire, Long idCommentaire);

    // DELETE

    // Supprime un commentaire
    String supprimeCommentaire(Long idCommentaire);

    // fonctions de recherche --------
    // Article
    public Article chercheArticle(Long id);

    /* Compte */

    // READ
    // public Compte chercheCompte(Article article);
}
