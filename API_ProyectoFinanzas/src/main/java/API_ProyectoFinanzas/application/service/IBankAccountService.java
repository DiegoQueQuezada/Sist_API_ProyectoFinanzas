package API_ProyectoFinanzas.application.service;

import API_ProyectoFinanzas.application.model.BankAccount;

import java.util.List;

public interface IBankAccountService {

    BankAccount register(BankAccount bankAccount);

    BankAccount update(BankAccount bankAccount);

    BankAccount findById(Integer id);

    List<BankAccount> findAll();

    void deleteById(Integer id);
}
