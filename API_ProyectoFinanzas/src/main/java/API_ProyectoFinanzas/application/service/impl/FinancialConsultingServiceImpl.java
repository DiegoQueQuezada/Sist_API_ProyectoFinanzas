package API_ProyectoFinanzas.application.service.impl;

import API_ProyectoFinanzas.application.model.FinancialConsulting;
import API_ProyectoFinanzas.application.repo.IFinancialConsultingRepo;
import API_ProyectoFinanzas.application.service.IFinancialConsultingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FinancialConsultingServiceImpl implements IFinancialConsultingService {

    private final IFinancialConsultingRepo repo;

    @Override
    public FinancialConsulting save(FinancialConsulting financialConsulting) {
        return repo.save(financialConsulting);
    }

    @Override
    public FinancialConsulting update(FinancialConsulting financialConsulting) {
        return repo.save(financialConsulting);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public FinancialConsulting findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<FinancialConsulting> findAll() {
        return repo.findAll();
    }
}
