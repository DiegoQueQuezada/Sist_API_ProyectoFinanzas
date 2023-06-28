package API_ProyectoFinanzas.application.service;

import API_ProyectoFinanzas.application.model.Contact;

import java.util.List;

public interface IContactService {

    Contact save(Contact contact);
    List<Contact> findAll();
}
