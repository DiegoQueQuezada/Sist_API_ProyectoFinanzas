package API_ProyectoFinanzas.application.repo;

import API_ProyectoFinanzas.application.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRepo extends JpaRepository<Card, Integer> {
}
