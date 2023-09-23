package com.kaci.blogspring0505.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.kaci.blogspring0505.entities.Compte;
import com.kaci.blogspring0505.repository.ICompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaci.blogspring0505.entities.Article;
import com.kaci.blogspring0505.entities.Commentaire;
import com.kaci.blogspring0505.repository.IArticleRepository;
import com.kaci.blogspring0505.repository.ICommentaireRepository;

import lombok.AllArgsConstructor;

@Service // Service est obligatoire
// @AllArgsConstructor // All Args ou Autowired
public class RedacteurServiceImpl implements IRedacteurService {

    @Autowired
    private IArticleRepository iArticleRepository;
    @Autowired
    private ICommentaireRepository iCommentaireRepository;
    @Autowired
    private ICompteRepository iCompteRepository;

    /** Article */
    // CREATE
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

    // READ
    @Override
    public List<Article> listeArticle() {
        return iArticleRepository.findAllArticles();
    }

    @Override
    public Article afficheArticle(Long idArticle) {
        return iArticleRepository.findByIdArticle(idArticle);
    }

    // UPDATE
    @Override
    public Article modifieArticle(Article article, Long idArticle) {
        Article articleSilExiste = iArticleRepository.findByIdArticle(idArticle); // cas erreur ?
        articleSilExiste.setTitre(article.getTitre());
        articleSilExiste.setContenu(article.getContenu());
        return iArticleRepository.save(articleSilExiste);
    }

    // DELETE

    @Override
    public String supprimeArticle(Long idArticle) {
        Article articleSilExiste = iArticleRepository.findByIdArticle(idArticle); // cas erreur ?
        iArticleRepository.delete(articleSilExiste);
        return "Article supprimé !";
    }

    // fonctions de recherche --------
    // Article
    @Override
    public Article chercheArticle(Long id) {
        Optional<Article> article = Optional.ofNullable(iArticleRepository.findByIdArticle(id));
        if (article.isPresent()) {
            return article.get();
        }
        throw new RuntimeException("Article introuvable");
    }

    /* Commentaire *******************/
    // CREATE
    // Crée un commentaire pour un article
    @Override
    public Commentaire creeCommentaire(Commentaire commentaire) {
        // commentaire.setArticle(article);
        return iCommentaireRepository.save(commentaire);
    }

    // READ
    // Affiche les commentaires d'un article
    @Override
    public List<Commentaire> listeCommentairesArticle(Article article) {
        return iCommentaireRepository.findCommentairesByArticle(article);
    }

    // Affiche un commentaire avec ID
    @Override
    public Commentaire afficheCommentaire(Long idCommentaire) {
        return iCommentaireRepository.findCommentaireByIdCommentaire(idCommentaire);
    }

    // UPDATE

    @Override
    public Commentaire updateCommentaire(Commentaire commentaire, Long idCommentaire) {
        Commentaire commentaireSilExiste = iCommentaireRepository.findCommentaireByIdCommentaire(idCommentaire); // cas
                                                                                                                 // erreur
                                                                                                                 // ?
        commentaireSilExiste.setContenu(commentaire.getContenu());
        return iCommentaireRepository.save(commentaireSilExiste);
    }

    // DELETE
    // Supprime un commentaire
    @Override
    public String supprimeCommentaire(Long idCommentaire) {
        Commentaire commentaire = iCommentaireRepository.findCommentaireByIdCommentaire(idCommentaire);
        iCommentaireRepository.delete(commentaire);
        return "Commentaire supprimé";
    }

    /* Compte *******************/
    // CREATE
    // Dans IInternanteService

    // READ
    // Affiche le compte d'un article

}
