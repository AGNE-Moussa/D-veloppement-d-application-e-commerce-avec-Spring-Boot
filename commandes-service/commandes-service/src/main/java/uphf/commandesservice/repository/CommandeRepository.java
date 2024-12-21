package uphf.commandesservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uphf.commandesservice.entite.Commande;
@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
}