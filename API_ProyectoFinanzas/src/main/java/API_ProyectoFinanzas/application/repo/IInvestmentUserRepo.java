package API_ProyectoFinanzas.application.repo;

import API_ProyectoFinanzas.application.model.InvestmentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvestmentUserRepo extends JpaRepository<InvestmentUser, Integer> {
}
