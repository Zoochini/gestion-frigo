package com.example.gestionfrigo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.gestionfrigo.model.Produit;
import com.example.gestionfrigo.model.ProduitRepository;
import com.example.gestionfrigo.service.ProduitService;

@Controller
@RequestMapping( path = "/" )
public class MainController {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private ProduitService    produitService;

    @GetMapping( path = "/index" )
    public String index() {
        return "pages/index";
    }

    @GetMapping( path = "/ajoutProduit" )
    public String ajoutProduitForm( Model model ) {
        model.addAttribute( "produit", new Produit() );
        return "pages/ajoutProduit";
    }

    @PostMapping( path = "/ajoutProduit" )
    public String ajoutProduitSubmit( @Valid @ModelAttribute Produit produit, BindingResult bindingResult,
            Model model ) {
        if ( bindingResult.hasErrors() ) {
            return "pages/ajoutProduit";
        } else {
            produitRepository.save( produit );
            model.addAttribute( "resultat", true );
            return "pages/ajoutProduit";
        }
    }

    @GetMapping( path = "/listeProduit" )
    public String listeProduit( @RequestParam( "page" ) Optional<Integer> page, Model model ) {
        Map<Integer, List<Produit>> produitsPages = produitService.produitPages( 2 );
        Integer pageCourante = page.orElse( 1 );
        model.addAttribute( "produits", produitsPages.get( pageCourante ) );
        model.addAttribute( "nbPages", produitsPages );
        model.addAttribute( "page", pageCourante );
        return "pages/listeProduit";
    }

    @GetMapping( path = "/script" )
    public String script() {
        return "pages/script";
    }

    @GetMapping( path = "/api", value = "/api" )
    @ResponseBody
    public String api() {
        return "{ \"test\": \"ok\" }";
    }

    @GetMapping( path = "/react" )
    public String react() {
        return "pages/react";
    }
}
