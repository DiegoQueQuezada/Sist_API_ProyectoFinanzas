package API_ProyectoFinanzas.application.service;

import API_ProyectoFinanzas.application.model.Card;

import java.util.List;

public interface ICardService {
    Card save(Card card);
    Card update(Card card);

    Card findById(Integer id);
    void delete(Integer id);

    List<Card> findAll();
}
