package API_ProyectoFinanzas.application.service;

import API_ProyectoFinanzas.application.model.FinancialConsulting;

import java.util.List;

public interface IFinancialConsultingService {

    FinancialConsulting save(FinancialConsulting financialConsulting);
    FinancialConsulting update(FinancialConsulting financialConsulting);
    void delete(Integer id);
    FinancialConsulting findById(Integer id);
    List<FinancialConsulting> findAll();
}
