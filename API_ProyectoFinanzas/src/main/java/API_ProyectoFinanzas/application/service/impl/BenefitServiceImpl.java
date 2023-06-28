package API_ProyectoFinanzas.application.service.impl;

import API_ProyectoFinanzas.application.model.Benefit;
import API_ProyectoFinanzas.application.repo.IBenefitRepo;
import API_ProyectoFinanzas.application.service.IBenefitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BenefitServiceImpl implements IBenefitService {

    private final IBenefitRepo benefitRepo;
    @Override
    public Benefit save(Benefit benefit) {
        return benefitRepo.save(benefit);
    }

    @Override
    public Benefit update(Benefit benefit) {
        return benefitRepo.save(benefit);
    }

    @Override
    public Benefit findById(Integer id) {
        return benefitRepo.findById(id).orElse(null);
    }

    @Override
    public List<Benefit> findAll() {
        return benefitRepo.findAll();
    }

    @Override
    public void delete(Integer id) {
        benefitRepo.deleteById(id);
    }
}
