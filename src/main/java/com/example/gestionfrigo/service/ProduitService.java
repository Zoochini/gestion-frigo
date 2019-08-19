package com.example.gestionfrigo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionfrigo.model.Produit;
import com.example.gestionfrigo.model.ProduitRepository;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public Map<Integer, List<Produit>> produitPages( int nbProduits ) {
        Map<Integer, List<Produit>> produitPages = new HashMap<Integer, List<Produit>>();
        Iterator<Produit> it = produitRepository.findAll().iterator();
        List<Produit> listProduits;
        int numPage = 0;
        while ( it.hasNext() ) {
            numPage++;
            listProduits = new ArrayList<Produit>();
            for ( int i = 0; i < nbProduits && it.hasNext(); i++ ) {
                listProduits.add( it.next() );
            }
            produitPages.put( numPage, listProduits );
        }
        return produitPages;
    }
}
