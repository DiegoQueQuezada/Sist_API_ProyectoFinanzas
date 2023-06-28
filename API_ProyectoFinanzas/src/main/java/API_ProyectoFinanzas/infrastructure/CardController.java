package API_ProyectoFinanzas.infrastructure;

import API_ProyectoFinanzas.application.exception.RecursoNoEncontrado;
import API_ProyectoFinanzas.application.model.Card;
import API_ProyectoFinanzas.application.service.ICardService;
import API_ProyectoFinanzas.application.util.WrapperResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cards")
public class CardController {

    private final ICardService cardService;

    @GetMapping()
    public ResponseEntity<WrapperResponse<List<Card>>> findAll() {
        List<Card> cards = cardService.findAll();

        return new WrapperResponse<>(true,"success",cards)
                .createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Card>> register(@Validated @RequestBody Card card){
        System.out.println(card);
        return new WrapperResponse<>(true,"success",cardService.save(card))
                .createResponse(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<WrapperResponse<Card>> update (@Validated @RequestBody Card card){

        Card cardFound = cardService.findById(card.getId());

        if(cardFound == null){
            throw new RecursoNoEncontrado("Card not found with ID: " + card.getId());
        }

        return new WrapperResponse<>(true,"success",cardService.update(card))
                .createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> deleteById(@PathVariable("id") Integer id){

        Card cardFound = cardService.findById(id);

        if(cardFound == null){
            throw new RecursoNoEncontrado("Card not found with ID: " + id);
        }

        cardService.delete(id);

        return new WrapperResponse<Void>(true,"success",null)
                .createResponse(HttpStatus.NO_CONTENT);
    }
}
