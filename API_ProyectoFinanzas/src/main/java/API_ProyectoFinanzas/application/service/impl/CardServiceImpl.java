package API_ProyectoFinanzas.application.service.impl;

import API_ProyectoFinanzas.application.model.Card;
import API_ProyectoFinanzas.application.repo.ICardRepo;
import API_ProyectoFinanzas.application.service.ICardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements ICardService {

    private final ICardRepo cardRepo;


    @Override
    public Card save(Card card) {
        return cardRepo.save(card);
    }

    @Override
    public Card update(Card card) {
        return cardRepo.save(card);
    }

    @Override
    public Card findById(Integer id) {
        return cardRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        cardRepo.deleteById(id);
    }

    @Override
    public List<Card> findAll() {
        return cardRepo.findAll();
    }
}
