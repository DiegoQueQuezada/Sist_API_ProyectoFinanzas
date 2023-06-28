package API_ProyectoFinanzas.application.service.impl;

import API_ProyectoFinanzas.application.model.Investment;
import API_ProyectoFinanzas.application.repo.IInvestmentRepo;
import API_ProyectoFinanzas.application.service.IInvestmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvestmentServiceImpl implements IInvestmentService {

    private final IInvestmentRepo repo;

    @Override
    public Investment save(Investment investment) {
        return repo.save(investment);
    }

    @Override
    public Investment findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public Investment update(Investment investment) {
        return repo.save(investment);
    }

    @Override
    public List<Investment> findAll() {
        return repo.findAll();
    }
}
