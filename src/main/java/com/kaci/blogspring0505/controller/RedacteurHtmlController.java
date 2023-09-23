package com.kaci.blogspring0505.controller;

import java.util.Date;
import java.util.List;

import com.kaci.blogspring0505.entities.Compte;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kaci.blogspring0505.entities.Article;
import com.kaci.blogspring0505.entities.Commentaire;
import com.kaci.blogspring0505.service.IRedacteurService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// @Controller // Utliser Thymleaf (jsp)
// @Primary
// @RestController // API - récupérer les données en format JSON
// @AllArgsConstructor
// @NoArgsConstructor
public class RedacteurHtmlController {

    @Qualifier("moderateurServiceImpl") // classe choisie en cas de conflit
    @Autowired // injection de dépendance
    private IRedacteurService iRedacteurService;

    /**
     * Article
     *******************/
    // CREATE
    @GetMapping("/redact/formArticle") // construit un article
    public String enregistreArticle(Article article, Model model) {//
        model.addAttribute("article", article);
        return "articles/formArticle";
    }

    @PostMapping("/redact/saveArticle") // sauvegarde l'article
    public String saveArticle(Article article, RedirectAttributes ra) { //
        // article.set_public(true);
        article.setModere(false);
        article.setDate(new Date());
        iRedacteurService.creeArticle(article);
        ra.addFlashAttribute("Article enregistré");
        return "redirect:/redact/index";
    }

    // READ
    // @GetMapping("/redact/index") // liste des articles
    // public String listeArticle(Model model) {
    // List<Article> articles = iRedacteurService.listeArticle();
    // model.addAttribute("listeArticles", articles);
    // return "articles/listeArticles";
    // }

    // Affiche article seul
    @GetMapping("/redact/affichearticle") // affiche un article selon son id
    public String afficheArticle(@RequestParam(name = "idArticle") Long id, Model model) {
        Article article = iRedacteurService.chercheArticle(id);
        model.addAttribute("article", article); // attributeName= nom attribut le doc HTML
        return "afficheArticle";
    }

    // UPDATE
    @GetMapping("/redact/editArticle") // édite le nouveau contenu d'un article
    public String editArticle(Model model, @RequestParam("idArticle") Long idArticle) {// (@Validated Article article,
                                                                                       // BindingResult bindingResult) {
        Article article = iRedacteurService.chercheArticle(idArticle);
        model.addAttribute("article", article);
        return "articles/editArticle";
        /*
         * try{
         * Article article = iRedacteurService.chercheArticle(idArticle);
         * model.addAttribute("article",article);
         * return "editArticle";
         * } catch (RuntimeException e){
         * return "redirect:/index";
         * }
         */
    }

    // DELETE
    @GetMapping("/redact/supprimearticle")
    public String supprimeArticle(@RequestParam(name = "idArticle") Long id) {
        iRedacteurService.supprimeArticle(id);
        return "redirect:/redact/index";
    }

    /**
     * Commentaires + article
     ******************/
    // Affiche article avec ses commentaires
    @GetMapping("/redact/listecommentairesarticle") // affiche un article avec compte et commentaires
    public String afficheArticleCommentaires(@RequestParam(name = "idArticle") Long id, Model model) {
        Article article = iRedacteurService.chercheArticle(id);
        // Compte compte = iRedacteurService.chercheCompte(article);
        List<Commentaire> commentaires = iRedacteurService.listeCommentairesArticle(article);
        model.addAttribute("article", article); // attributeName= nom attribut le doc HTML
        // model.addAttribute("compte", compte);
        model.addAttribute("listecommentaires", commentaires);
        return "commentaires/listeCommentairesArticle";
    }

    /** Commentaire **********************/
    // CREATE

    // Formulaire pour créer un commentaire pour un article
    @GetMapping("/redact/formcommentaire")
    public String formCommentaire(Commentaire commentaire, @RequestParam(name = "idArticle") Long idArticle,
            Model model) {//
        // Article article = new Article();
        Article article = iRedacteurService.chercheArticle(idArticle);
        model.addAttribute("commentaire", commentaire);
        model.addAttribute("article", article);
        model.addAttribute("idArticle", idArticle);
        return "commentaires/formCommentaire";
    }

    @PostMapping("/redact/saveCommentaire") // sauvegarde le commentaire
    public String saveCommentaire(Commentaire commentaire, @RequestParam(name = "idArticle") Long id,
            RedirectAttributes ra) { //
        // commentaire.set_public(true);
        Article article = iRedacteurService.chercheArticle(id);
        commentaire.setArticle(article);
        commentaire.setModere(false);
        commentaire.setDate(new Date());
        iRedacteurService.creeCommentaire(commentaire);
        ra.addFlashAttribute("Article enregistré");
        return "redirect:/redact/index";
        // return "redirect:/redact/listecommentairesarticle(idArticle=id)"; //?
    }

    // READ
    // Affiche un commentaire
    @GetMapping("/redact/affichecommentaire") // avec son id
    public String afficheCommentaire(@RequestParam(name = "idCommentaire") Long id, Model model) {
        Commentaire commentaire = iRedacteurService.afficheCommentaire(id);
        model.addAttribute("commentaire", commentaire);
        return "commentaires/afficheCommentaire";
    }

    /** avec compte */
    @GetMapping("/redact/comptearticle") // index des articles
    public String compteArticle(@RequestParam(name = "idArticle") Long id, Model model) {
        Article article = iRedacteurService.chercheArticle(id);
        System.out.println(article.getTitre());
        // Compte compte = iRedacteurService.chercheCompte(article);
        // System.out.println(compte.getPseudo());
        // model.addAttribute("compte", compte);
        return "comptes/compteArticle";
    }

    // DELETE
    // supprime un commentaire
    @GetMapping("/redact/supprimecommentaire") // avec son id
    public String supprimeCommentaire(@RequestParam(name = "idCommentaire") Long id,
            @RequestParam(name = "idArticle") Long idArticle) {
        iRedacteurService.supprimeCommentaire(id);
        return "redirect:/redact/index"; // à modifier : faire le retour vers la liste des commentaires
    }

}
