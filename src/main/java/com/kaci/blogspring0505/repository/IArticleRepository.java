package com.kaci.blogspring0505.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kaci.blogspring0505.entities.Article;
import java.util.List;

public interface IArticleRepository extends JpaRepository<Article, Long> {
    /*** Articles *************/

    // CREATE
    // Créer un article

    // READ
    // liste de tous les articles
    // @Query(value = "SELECT * FROM article", nativeQuery = true)
    @Query("Select a from Article a") // ça marche
    List<Article> findAllArticles();

    // Recherche d'un article avec son Id
    Article findByIdArticle(Long idArticle);

    // Liste des articles en attente de modération
    List<Article> findArticlesByModereIsFalse();

    // READ
    // Accueil site : Liste Articles publiques
    List<Article> findArticlesBy_publicIsTrue();
}
