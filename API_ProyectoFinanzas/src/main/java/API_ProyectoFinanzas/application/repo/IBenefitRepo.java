package API_ProyectoFinanzas.application.repo;

import API_ProyectoFinanzas.application.model.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBenefitRepo extends JpaRepository<Benefit, Integer> {
}
