package API_ProyectoFinanzas.application.service;

import API_ProyectoFinanzas.application.model.InvestmentUser;

import java.util.List;

public interface IInvestmentUserService {
    InvestmentUser save(InvestmentUser investmentUser);
    InvestmentUser update(InvestmentUser investmentUser);
    InvestmentUser findById(Integer id);
    void delete(Integer id);
    List<InvestmentUser> findAll();
}
