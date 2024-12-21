package uphf.commandesservice.service;
import uphf.commandesservice.entite.Commande;
import java.util.List;
public interface CommandeService {
    List<Commande> getAllCommandes();
    Commande getCommandeById(Long id);
    Commande createCommande(Commande commande);
    Commande updateCommande(Long id, Commande commandeDetails);
    void deleteCommande(Long id);
}