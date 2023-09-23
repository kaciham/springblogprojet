package com.kaci.blogspring0505.controller;

import com.kaci.blogspring0505.entities.Article;
import com.kaci.blogspring0505.entities.Compte;
import com.kaci.blogspring0505.service.IInternauteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

// @Controller
public class InternauteHtmlController {
    @Autowired
    private IInternauteService iInternauteService;

    /* Article */
    // READ
    // Accueil site : liste des articles publics
    @GetMapping("/index") //
    public String listeArticlesPublic(Model model) {//
        List<Article> articles = iInternauteService.listeArticlesPublic();
        return "index";
    }

    /* Compte */
    // CREATE
    @PostMapping("/public/creecompte") // sauvegarde dans la BD
    public String creeCompte(Compte compte, RedirectAttributes ra) { //
        compte.setBani(false);
        compte.setEfface(false);
        compte.setSignale(false);
        compte.setEfface(false);
        compte.setSupressionDonnee(false);
        compte.setValide(false);
        // compte.setTypeCompte(); // à faire
        iInternauteService.creeCompte(compte);
        ra.addFlashAttribute("Compte créé");
        return "redirect:/redact/index"; // provisoire, normalement "redirect:/public/index"
    }
    /*
     * @GetMapping("/redact/creecompte") // construit
     * public String creeCompte(Compte compte, Model model){//
     * model.addAttribute("compte", compte);
     * return "creeCompte";
     * }
     */

}
