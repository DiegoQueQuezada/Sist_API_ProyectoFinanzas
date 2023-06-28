package API_ProyectoFinanzas.application.service.impl;

import API_ProyectoFinanzas.application.model.BankAccount;
import API_ProyectoFinanzas.application.model.Transaction;
import API_ProyectoFinanzas.application.repo.ITransactionRepo;
import API_ProyectoFinanzas.application.service.IBankAccountService;
import API_ProyectoFinanzas.application.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements ITransactionService {

    private final ITransactionRepo transactionRepo;

    private final IBankAccountService iBankAccountService;

    @Transactional
    @Override
    public Transaction save(Transaction transaction) {

        BankAccount bankAccountTransaction = iBankAccountService.findById(transaction.getBankAccount().getId());

        switch (transaction.getOperation()) {
            case RETIRAR -> {
                bankAccountTransaction.withdraw(transaction.getAmount());
                iBankAccountService.update(bankAccountTransaction);
            }
            case DEPOSITAR -> {
                bankAccountTransaction.deposit(transaction.getAmount());
                iBankAccountService.update(bankAccountTransaction);
            }
            default -> throw new IllegalArgumentException("Operación no soportada: " + transaction.getOperation());
        }
        transaction.setBankAccount(bankAccountTransaction);
        transaction.setDateCreated(LocalDateTime.now());
        return transactionRepo.save(transaction);
    }

    @Override
    public Transaction findById(Integer id) {
        return transactionRepo.findById(id).orElse(null);
    }

    @Override
    public Transaction update(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    @Override
    public void delete(Integer id) {
        transactionRepo.deleteById(id);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepo.findAll();
    }

    @Override
    public List<Transaction> findAllByBankAccount(Integer id){
        return transactionRepo.findAll().stream().filter(transaction -> transaction.getBankAccount().getId().equals(id)).toList();
    }
}
