package uphf.commandesservice.entite;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCOMMANDE")
    private Long idCommande;

    @Column(name = "NOMCLIENT")
    private String nomClient;
    @Column(name = "PRIXTOTAL")
    private BigDecimal prixTotal;
    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CommandeArticle> commandeArticles;
}