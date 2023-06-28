package API_ProyectoFinanzas.application.repo;

import API_ProyectoFinanzas.application.model.FinancialConsulting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFinancialConsultingRepo extends JpaRepository<FinancialConsulting, Integer> {
}
