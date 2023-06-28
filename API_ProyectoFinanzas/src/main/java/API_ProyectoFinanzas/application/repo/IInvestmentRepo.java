package API_ProyectoFinanzas.application.repo;

import API_ProyectoFinanzas.application.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvestmentRepo extends JpaRepository<Investment, Integer> {
}
