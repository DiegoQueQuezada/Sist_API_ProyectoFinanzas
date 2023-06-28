package API_ProyectoFinanzas.application.repo;

import API_ProyectoFinanzas.application.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepo extends JpaRepository<Contact, Integer> {
}
