package API_ProyectoFinanzas.application.repo;

import API_ProyectoFinanzas.application.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionRepo extends JpaRepository<Transaction, Integer> {

    List<Transaction> findAllByBankAccount(Integer bankAccount);
}
