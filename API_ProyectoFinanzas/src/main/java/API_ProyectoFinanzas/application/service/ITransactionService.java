package API_ProyectoFinanzas.application.service;

import API_ProyectoFinanzas.application.model.Transaction;

import java.util.List;

public interface ITransactionService {

    Transaction save(Transaction transaction);
    Transaction findById(Integer id);
    Transaction update(Transaction transaction);
    void delete(Integer id);
    List<Transaction> findAll();
    List<Transaction> findAllByBankAccount(Integer id);
}
