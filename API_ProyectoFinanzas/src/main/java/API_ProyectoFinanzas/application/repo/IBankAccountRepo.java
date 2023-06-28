package API_ProyectoFinanzas.application.repo;

import API_ProyectoFinanzas.application.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBankAccountRepo extends JpaRepository<BankAccount, Integer> {
}
