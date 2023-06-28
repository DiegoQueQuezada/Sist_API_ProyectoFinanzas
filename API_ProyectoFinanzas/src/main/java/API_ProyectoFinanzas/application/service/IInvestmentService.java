package API_ProyectoFinanzas.application.service;

import API_ProyectoFinanzas.application.model.Investment;

import java.util.List;

public interface IInvestmentService {

    Investment save(Investment investment);
    Investment findById(int id);
    void deleteById(int id);
    Investment update(Investment investment);
    List<Investment> findAll();
}
