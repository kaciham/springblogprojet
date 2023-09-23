package com.kaci.blogspring0505.service;

import com.kaci.blogspring0505.entities.Article;
import com.kaci.blogspring0505.entities.Commentaire;
import com.kaci.blogspring0505.entities.Compte;
import com.kaci.blogspring0505.repository.IArticleRepository;
import com.kaci.blogspring0505.repository.ICommentaireRepository;
import com.kaci.blogspring0505.repository.ICompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternauteServiceImpl implements IInternauteService {
    @Autowired
    private IArticleRepository iArticleRepository;
    @Autowired
    private ICommentaireRepository iCommentaireRepository;
    @Autowired
    private ICompteRepository iCompteRepository;

    /* Article */
    // READ
    // Accueil site : Liste Articles publiques
    @Override
    public List<Article> listeArticlesPublic() {
        return iArticleRepository.findArticlesBy_publicIsTrue();
    }

    /* Commentaires */
    // READ
    // Liste Commentaires publiques d'un article
    public List<Commentaire> listeCommentairesPublic(Article article) {
        return iCommentaireRepository.findCommentairesBy_publicIsTrueAndArticle(article);
    }

    @Override
    public Compte creeCompte(Compte compte) {
        return iCompteRepository.save(compte);
    }

    @Override
    public Article afficheArticlePublic(Long idArticle) {
        return iArticleRepository.findByIdArticle(idArticle);
    }
}
