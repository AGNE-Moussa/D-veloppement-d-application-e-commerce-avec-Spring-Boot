package uphf.produitsservice.entite;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "produits")

public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOMPRODUIT")
    private String nomProduit;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRIX")
    private BigDecimal prix;
    @Column(name = "QUANTITE")
    private int quantite;
}