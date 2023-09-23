package com.kaci.blogspring0505.service;

import com.kaci.blogspring0505.entities.Article;
import com.kaci.blogspring0505.entities.Commentaire;
import com.kaci.blogspring0505.entities.Compte;

import java.util.List;

public interface IInternauteService {
    /* Article */
    // READ
    // Accueil site : Liste Articles publiques
    List<Article> listeArticlesPublic();

    // lire un article avec son id
    Article afficheArticlePublic(Long idArticle);

    /* Commentaires */
    // READ
    // Liste Commentaires publiques d'un article
    List<Commentaire> listeCommentairesPublic(Article article);

    /* Compte */
    // CREATE
    Compte creeCompte(Compte compte);
}
