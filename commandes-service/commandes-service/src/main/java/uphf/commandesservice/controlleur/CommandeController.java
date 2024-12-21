package uphf.commandesservice.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import uphf.commandesservice.entite.Commande;
import uphf.commandesservice.service.CommandeService;

import java.util.List;
@RestController
@RequestMapping("/api/commandes")
public class CommandeController {
    @Autowired
    private WebClient.Builder webClient;

    @Autowired
    private CommandeService commandeService;
    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandeService.getCommandeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Commande createCommande(@RequestBody Commande commande) {
        return commandeService.createCommande(commande);
    }

    @PutMapping("/{id}")
    public Commande updateCommande(@PathVariable Long id, @RequestBody Commande commandeDetails) {
        return commandeService.updateCommande(id, commandeDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
    }
}