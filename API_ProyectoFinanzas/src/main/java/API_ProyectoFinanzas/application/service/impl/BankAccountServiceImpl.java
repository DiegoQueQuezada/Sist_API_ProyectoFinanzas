package API_ProyectoFinanzas.application.service.impl;

import API_ProyectoFinanzas.application.model.BankAccount;
import API_ProyectoFinanzas.application.model.Card;
import API_ProyectoFinanzas.application.repo.IBankAccountRepo;
import API_ProyectoFinanzas.application.repo.ICardRepo;
import API_ProyectoFinanzas.application.service.IBankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements IBankAccountService {

    private final IBankAccountRepo bankAccountRepo;

    @Override
    public BankAccount register(BankAccount bankAccount) {
        bankAccount.setDateCreated(LocalDate.now());
        return bankAccountRepo.save(bankAccount);
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        return bankAccountRepo.save(bankAccount);
    }

    @Override
    public BankAccount findById(Integer id) {
        return bankAccountRepo.findById(id).orElse(null);
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        bankAccountRepo.deleteById(id);
    }

}
