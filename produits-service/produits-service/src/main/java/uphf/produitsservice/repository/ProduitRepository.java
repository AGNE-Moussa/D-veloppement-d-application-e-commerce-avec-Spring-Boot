package uphf.produitsservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uphf.produitsservice.entite.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}