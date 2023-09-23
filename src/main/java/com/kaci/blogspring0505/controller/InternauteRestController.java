package com.kaci.blogspring0505.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaci.blogspring0505.entities.Article;
import com.kaci.blogspring0505.service.IInternauteService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class InternauteRestController {

    @Autowired
    private IInternauteService iInternauteService;

    // READ
    @GetMapping("/internaute/articles")
    public List<Article> listeArticlesPublic() {
        return iInternauteService.listeArticlesPublic();
    }

    @GetMapping("/internaute/article/{idArticle}")
    public Article afficheArticle(@PathVariable Long idArticle) {
        return iInternauteService.afficheArticlePublic(idArticle);
    }

}
