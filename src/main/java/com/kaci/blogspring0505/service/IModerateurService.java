package com.kaci.blogspring0505.service;

import com.kaci.blogspring0505.entities.Article;
import com.kaci.blogspring0505.entities.Commentaire;

import java.util.List;

public interface IModerateurService {
    /*** Articles *************/
    // CREATE
    // Creer un article
    Article creeArticle(Article article);

    //
    // READ
    // Liste des articles en attente de modération
    List<Article> listeArticlesNonModere();

    /*** Commentaires *************/
    // READ
    // Liste des Commentaires en attente de modération
    List<Commentaire> listeCommentairesNonModere();

}
