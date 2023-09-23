package com.kaci.blogspring0505.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaci.blogspring0505.entities.Article;
import com.kaci.blogspring0505.entities.Commentaire;
import com.kaci.blogspring0505.service.IModerateurService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ModerateurRestController {

    @Autowired
    private IModerateurService iModerateurService;

    // ARTICLE
    // CREATE
    // Cree un article

    // @PostMapping("/moderateur/nouvelarticle")
    // public Article creeArticle(@RequestBody Article article) { // @RequestBody
    // article.set_public(true); // par défaut (consignes)
    // article.setModere(true); // par défaut (consignes)
    // article.setDate(new Date());
    // return iModerateurService.creeArticle(article);
    // }

    // READ
    // Lire les articles non modérés

    @GetMapping("/moderateur/articlesnonmoderes")
    public List<Article> listeArticlesNonModere() {
        // List<Article> article = iModerateurService.listeArticlesNonModere();
        // model.addAttribute("article", article);
        return iModerateurService.listeArticlesNonModere();
    }

    // Lire les commentaires non modérés

    @GetMapping("/moderateur/commentairesnonmoderes")
    public List<Commentaire> listeCommentairesNonModere() {
        return iModerateurService.listeCommentairesNonModere();
    }
}
