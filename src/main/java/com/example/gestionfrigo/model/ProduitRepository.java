package com.example.gestionfrigo.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {

}
