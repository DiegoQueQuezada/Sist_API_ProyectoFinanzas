package API_ProyectoFinanzas.infrastructure;

import API_ProyectoFinanzas.application.exception.RecursoNoEncontrado;
import API_ProyectoFinanzas.application.model.Investment;
import API_ProyectoFinanzas.application.service.IInvestmentService;
import API_ProyectoFinanzas.application.util.WrapperResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/investments")
@RestController
public class InvestmentController {

    private final IInvestmentService service;

    @GetMapping()
    public ResponseEntity<WrapperResponse<List<Investment>>> findAll() {
        List<Investment> investments = service.findAll();

        return new WrapperResponse<>(true,"success",investments)
                .createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Investment>> register(@Validated @RequestBody Investment investment){
        return new WrapperResponse<>(true,"success",service.save(investment))
                .createResponse(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<WrapperResponse<Investment>> update (@Validated @RequestBody Investment investment){

        Investment investmentFound = service.findById(investment.getId());

        if(investmentFound == null){
            throw new RecursoNoEncontrado("Card not found with ID: " + investment.getId());
        }

        return new WrapperResponse<>(true,"success",service.update(investment))
                .createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> deleteById(@PathVariable("id") Integer id){

        Investment investmentFound = service.findById(id);

        if(investmentFound == null){
            throw new RecursoNoEncontrado("Card not found with ID: " + id);
        }

        service.deleteById(id);

        return new WrapperResponse<Void>(true,"success",null)
                .createResponse(HttpStatus.NO_CONTENT);
    }
}
