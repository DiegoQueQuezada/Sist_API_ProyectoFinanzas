package API_ProyectoFinanzas.infrastructure;

import API_ProyectoFinanzas.application.model.Contact;
import API_ProyectoFinanzas.application.service.IContactService;
import API_ProyectoFinanzas.application.util.WrapperResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/contacts")
public class ContactController {

    private final IContactService contactService;

    @PostMapping
    public ResponseEntity<WrapperResponse<Contact>> register(@Validated @RequestBody Contact contact){
        return new WrapperResponse<>(true,"success",contactService.save(contact))
                .createResponse(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<WrapperResponse<List<Contact>>> findAll() {
        List<Contact> contacts = contactService.findAll();

        return new WrapperResponse<>(true,"success",contacts)
                .createResponse(HttpStatus.OK);
    }
}
