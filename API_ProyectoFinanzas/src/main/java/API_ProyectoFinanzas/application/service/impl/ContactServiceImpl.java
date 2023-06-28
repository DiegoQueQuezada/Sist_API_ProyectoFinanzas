package API_ProyectoFinanzas.application.service.impl;

import API_ProyectoFinanzas.application.model.Contact;
import API_ProyectoFinanzas.application.repo.IContactRepo;
import API_ProyectoFinanzas.application.service.IContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {

    private final IContactRepo contactRepo;

    @Override
    public Contact save(Contact contact) {
        return contactRepo.save(contact);
    }

    @Override
    public List<Contact> findAll() {
        return contactRepo.findAll();
    }
}
