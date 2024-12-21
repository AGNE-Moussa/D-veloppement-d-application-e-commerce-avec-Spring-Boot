package uphf.produitsservice.service;

import uphf.produitsservice.entite.Produit;

import java.util.List;

public interface ProduitService {
    List<Produit> getAllProduits();
    Produit getProduitById(Long id);
    Produit createProduit(Produit produit);
    Produit updateProduit(Long id, Produit produitDetails);
    void deleteProduit(Long id);
}
