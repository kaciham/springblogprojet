package com.kaci.blogspring0505.controller;

import com.kaci.blogspring0505.entities.Article;
import com.kaci.blogspring0505.entities.Commentaire;
import com.kaci.blogspring0505.service.IModerateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// @Controller
public class ModerateurHtmlController {
    @Qualifier("moderateurServiceImpl")
    @Autowired
    private IModerateurService iModerateurService;

    /*** Articles *************/
    // READ
    // Accueil modérateur
    @GetMapping("/moder/index")
    public String indexModerateur() {
        return "indexModerateur";
    }

    // Liste des articles en attente de modération
    @GetMapping("/moder/listearticlesnonmodere")
    public String listeArticlesNonModere(Model model) {
        List<Article> articles = iModerateurService.listeArticlesNonModere();
        model.addAttribute("listeArticles", articles);
        return "articles/listeArticles";
    }

    /*** Commentaire *************/
    // Liste des Commentaires en attente de modération
    @GetMapping("/moder/listecommentairesnonmodere")
    public String listeCommentairesNonModere(Model model) {
        List<Commentaire> commentaires = iModerateurService.listeCommentairesNonModere();
        model.addAttribute("listeCommentaires", commentaires);
        return "commentaires/listeCommentaires";
    }
}
