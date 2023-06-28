package API_ProyectoFinanzas.application.service.impl;

import API_ProyectoFinanzas.application.model.InvestmentUser;
import API_ProyectoFinanzas.application.repo.IInvestmentUserRepo;
import API_ProyectoFinanzas.application.service.IInvestmentUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InvestmentUserServiceImpl implements IInvestmentUserService {

    private final IInvestmentUserRepo investmentUserRepo;

    @Override
    public InvestmentUser save(InvestmentUser investmentUser) {
        return investmentUserRepo.save(investmentUser);
    }

    @Override
    public InvestmentUser update(InvestmentUser investmentUser) {
        return investmentUserRepo.save(investmentUser);
    }

    @Override
    public InvestmentUser findById(Integer id) {
        return investmentUserRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        investmentUserRepo.deleteById(id);
    }

    @Override
    public List<InvestmentUser> findAll() {
        return investmentUserRepo.findAll();
    }
}
