package com.kaci.blogspring0505.service;

import com.kaci.blogspring0505.entities.Article;
import com.kaci.blogspring0505.entities.Commentaire;
import com.kaci.blogspring0505.repository.IArticleRepository;
import com.kaci.blogspring0505.repository.ICommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModerateurServiceImpl implements IModerateurService {
    /*
     * public ModerateurServiceImpl(IArticleRepository iArticleRepository,
     * ICommentaireRepository iCommentaireRepository, ICompteRepository
     * iCompteRepository) {
     * super(iArticleRepository, iCommentaireRepository, iCompteRepository);
     * }
     */
    @Autowired
    private IArticleRepository iArticleRepository;
    @Autowired
    private ICommentaireRepository iCommentaireRepository;

    // ARTICLE
    // Create

    @Override
    public Article creeArticle(Article article) {
        /*
         * article.set_public(true);
         * article.setModere(false);
         * article.setTitre("Le titre");
         * article.setContenu("Le contenu");
         * article.setDate(new Date());
         */
        return iArticleRepository.save(article);
    }

    @Override
    public List<Article> listeArticlesNonModere() {
        return iArticleRepository.findArticlesByModereIsFalse();
    }

    /*** Commentaires *************/
    // READ
    // Liste des Commentaires en attente de modération
    @Override
    public List<Commentaire> listeCommentairesNonModere() {
        return iCommentaireRepository.findCommentairesByModereIsFalse();
    }
}
