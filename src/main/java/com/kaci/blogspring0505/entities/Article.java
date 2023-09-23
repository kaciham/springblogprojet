package com.kaci.blogspring0505.entities;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import org.hibernate.validator.internal.util.privilegedactions.GetDeclaredField;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticle;
    // @AssertTrue
    private boolean _public;
    private boolean modere;
    private String titre;
    private String contenu;
    @Temporal(TemporalType.DATE)
    // @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @ManyToOne
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //optionnel: évite
    // d'afficher systématiquement le compte
    private Compte compte;

}
