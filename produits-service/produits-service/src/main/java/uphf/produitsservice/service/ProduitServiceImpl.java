package uphf.produitsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uphf.produitsservice.entite.Produit;
import uphf.produitsservice.exception.ResourceNotFoundException;
import uphf.produitsservice.repository.ProduitRepository;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit getProduitById(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit avec le id " + id + " n'existe pas"));
    }

    @Override
    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(Long id, Produit produitDetails) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit avec le id " + id + " n'existe pas"));

        produit.setNomProduit(produitDetails.getNomProduit());
        produit.setDescription(produitDetails.getDescription());
        produit.setPrix(produitDetails.getPrix());
        produit.setQuantite(produitDetails.getQuantite());

        return produitRepository.save(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit avec le id " + id + " n'existe pas"));

        produitRepository.delete(produit);
    }
}