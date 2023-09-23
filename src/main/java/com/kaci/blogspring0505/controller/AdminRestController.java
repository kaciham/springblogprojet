package com.kaci.blogspring0505.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaci.blogspring0505.entities.Compte;
import com.kaci.blogspring0505.service.IAdminService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AdminRestController {

    @Autowired
    private IAdminService iAdminService;

    // READ
    @GetMapping("/admin/comptes")
    public List<Compte> afficheComptesNonValides() {
        return iAdminService.listeCompteNonValide();
    }

}
