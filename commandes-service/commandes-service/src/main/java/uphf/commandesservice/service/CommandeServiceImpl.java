package uphf.commandesservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import uphf.commandesservice.entite.Commande;
import uphf.commandesservice.exception.ResourceNotFoundException;
import uphf.commandesservice.repository.CommandeRepository;
import uphf.produitsservice.entite.Produit;

import java.util.List;
@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private WebClient.Builder webClientBuilder;
    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande getCommandeById(Long idCommande) {
        return commandeRepository.findById(idCommande)
                .orElseThrow(() -> new ResourceNotFoundException("Commande avec l'id " + idCommande + " n'existe pas"));
    }
    @Override
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Long idCommande, Commande commandeDetails) {
        Commande commande = commandeRepository.findById(idCommande)
                .orElseThrow(() -> new ResourceNotFoundException("Commande avec l'id " + idCommande + " n'existe pas"));

        commande.setNomClient(commandeDetails.getNomClient());
        commande.setPrixTotal(commandeDetails.getPrixTotal());
        commande.setCommandeArticles(commandeDetails.getCommandeArticles());

        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommande(Long idCommande) {
        Commande commande = commandeRepository.findById(idCommande)
                .orElseThrow(() -> new ResourceNotFoundException("Commande avec l'id " + idCommande + " n'existe pas"));

        commandeRepository.delete(commande);
    }
    public void quelqueChose() {
        // Créer un WebClient à l'aide du Builder injecté
        WebClient webClient = webClientBuilder.build();

        // Effectuer un appel équilibré de charge vers le service de produits
        Produit produit = webClient.get()
                .uri("http://produits-service/api/produits/{id}", 1L)
                .retrieve()
                .bodyToMono(Produit.class)
                .block();
    }

    public List<Produit> getAllProduits() {
        WebClient webClient = webClientBuilder.build();

        List<Produit> produits = webClient.get()
                .uri("http://produits-service/api/produits")
                .retrieve()
                .bodyToFlux(Produit.class)
                .collectList()
                .block();

        return produits;
    }

    public Produit createProduit(Produit nouveauProduitDetails) {
        WebClient webClient = webClientBuilder.build();

        Produit nouveauProduit = webClient.post()
                .uri("http://produits-service/api/produits")
                .body(Mono.just(nouveauProduitDetails), Produit.class)
                .retrieve()
                .bodyToMono(Produit.class)
                .block();

        return nouveauProduit;
    }

    public Produit updateProduit(Long idProduit, Produit produitDetails) {
        WebClient webClient = webClientBuilder.build();

        Produit produitMisAJour = webClient.put()
                .uri("http://produits-service/api/produits/{id}", idProduit)
                .body(Mono.just(produitDetails), Produit.class)
                .retrieve()
                .bodyToMono(Produit.class)
                .block();

        return produitMisAJour;
    }

    public void deleteProduit(Long idProduit) {
        WebClient webClient = webClientBuilder.build();

        webClient.delete()
                .uri("http://produits-service/api/produits/{id}", idProduit)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

}