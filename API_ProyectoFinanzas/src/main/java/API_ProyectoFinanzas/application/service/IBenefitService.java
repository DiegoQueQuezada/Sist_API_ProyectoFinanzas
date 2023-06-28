package API_ProyectoFinanzas.application.service;

import API_ProyectoFinanzas.application.model.Benefit;

import java.util.List;

public interface IBenefitService {

    Benefit save(Benefit benefit);
    Benefit update(Benefit benefit);
    Benefit findById(Integer id);
    List<Benefit> findAll();
    void delete(Integer id);

}
