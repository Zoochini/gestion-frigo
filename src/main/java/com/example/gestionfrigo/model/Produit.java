package com.example.gestionfrigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Produit {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long   id;

    @Column( name = "nom" )
    @NotNull
    @Size( min = 2, max = 15 )
    private String nom;

    @Column( name = "quantite" )
    @NotNull
    private Long   quantite;

    public Produit( String nom, Long quantite ) {
        this.nom = nom;
        this.quantite = quantite;
    }

    public Produit() {
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite( Long quantite ) {
        this.quantite = quantite;
    }
}
