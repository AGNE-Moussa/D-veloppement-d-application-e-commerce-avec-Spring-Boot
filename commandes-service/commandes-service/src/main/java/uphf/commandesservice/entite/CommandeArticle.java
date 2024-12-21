package uphf.commandesservice.entite;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commande_articles")
public class CommandeArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDARTICLE")
    private Long idArticle;

    @Column(name = "NOMARTICLE")
    private String nomArticle;
    @Column(name = "PRIX")
    private BigDecimal prix;
    @Column(name = "QUANTITE")
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "idcommande")
    @JsonBackReference
    private Commande commande;
}