package com.kaci.blogspring0505;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kaci.blogspring0505.entities.Article;
import com.kaci.blogspring0505.entities.Commentaire;
import com.kaci.blogspring0505.entities.Compte;
import com.kaci.blogspring0505.entities.TypeCompte;
import com.kaci.blogspring0505.repository.IArticleRepository;
import com.kaci.blogspring0505.repository.ICommentaireRepository;
import com.kaci.blogspring0505.repository.ICompteRepository;
import com.kaci.blogspring0505.repository.ITypeCompteRepository;

@SpringBootApplication
public class Blogspring0505Application {

    public static void main(String[] args) {
        SpringApplication.run(Blogspring0505Application.class, args);
        System.out.println("Bien démarré --- port:8090 ---");
    }

    // Initialisation des données /******* Exécution au démarrage*/
    // TypeCompte
    // @Bean
    CommandLineRunner start(ITypeCompteRepository iTypeCompteRepository,
            ICompteRepository iCompteRepository,
            IArticleRepository iArticleRepository,
            ICommentaireRepository iCommentaireRepository) {
        // TypeCompte
        return args -> {
            /*
             * Stream.of("redacteur", "moderateur", "admin")
             * .forEach(label -> {
             * TypeCompte typeCompte = new TypeCompte();
             * typeCompte.setLabel(label);
             * 
             * iTypeCompteRepository.save(typeCompte);
             * 
             * });
             * 
             */
            // Compte
            TypeCompte typeCompte1 = iTypeCompteRepository.findById(1L).orElse(null);

            Stream.of("Moh", "Kaci", "Saly", "Margot")
                    .forEach(pseudo -> {
                        Compte compte = new Compte();
                        compte.setPseudo(pseudo);
                        compte.setEmail(pseudo + "@hamroun.fr");
                        compte.setMotDePasse("1234");
                        compte.setBani(Math.random() > 0.1 ? false : true);
                        compte.setEfface((Math.random() > 0.1 ? false : true));
                        compte.setSignale(Math.random() > 0.1 ? false : true);
                        compte.setValide(Math.random() > 0.7 ? false : true);
                        // /compte.setTypeCompte(typeCompte1);/

                        iCompteRepository.save(compte);

                    });

            // Article
            Compte compte1 = iCompteRepository.findById(1L).orElse(null);
            Stream.of("La fac", "A développer", "Le social", "La com")
                    .forEach(titre -> {
                        Article article = new Article();
                        article.setTitre(titre);
                        article.setContenu("Contenu de " + "\'" + titre + "\'");
                        article.setDate(new Date());
                        article.setModere(Math.random() > 0.5 ? false : true);
                        article.set_public(Math.random() > 0.1 ? true : false);
                        article.setCompte(compte1);

                        iArticleRepository.save(article);

                    });
            // Commentaire
            Article article = iArticleRepository.findById(Math.random() > 0.8 ? 1L : 2L).orElse(null);
            Compte compte2 = iCompteRepository.findById(21L).orElse(null);
            Stream.of("Bien", "Très bien", "Passionnément", "Pas du tout")
                    .forEach(contenu -> {
                        Commentaire commentaire = new Commentaire();
                        commentaire.setContenu(contenu);
                        commentaire.setDate(new Date());
                        commentaire.set_public(Math.random() > 0.8 ? false : true);
                        commentaire.setModere(Math.random() > 0.8 ? false : true);
                        commentaire.setArticle(article);
                        commentaire.setCompte(compte2);

                        iCommentaireRepository.save(commentaire);

                    });
        };
    }
}
