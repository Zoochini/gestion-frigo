package com.example.gestionfrigo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.gestionfrigo.model.Produit;
import com.example.gestionfrigo.model.ProduitRepository;

@Component
public class GestionFrigoRunner implements CommandLineRunner {

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public void run( String... args ) throws Exception {
        // TODO Auto-generated method stub
        produitRepository.save( (Produit) new Produit( "Fraise", (long) 6 ) );
        produitRepository.save( (Produit) new Produit( "Citron", (long) 3 ) );
        produitRepository.save( (Produit) new Produit( "Poisson", (long) 2 ) );
        produitRepository.save( (Produit) new Produit( "Pizza", (long) 1 ) );
        produitRepository.save( (Produit) new Produit( "Courgette", (long) 4 ) );

    }
}
