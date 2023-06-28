package API_ProyectoFinanzas.infrastructure;

import API_ProyectoFinanzas.application.exception.RecursoNoEncontrado;
import API_ProyectoFinanzas.application.model.Benefit;
import API_ProyectoFinanzas.application.service.IBenefitService;
import API_ProyectoFinanzas.application.util.WrapperResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/benefits")
@RestController
public class BenefitController {

    private final IBenefitService benefitService;

    @GetMapping()
    public ResponseEntity<WrapperResponse<List<Benefit>>> findAll() {
        List<Benefit> benefits = benefitService.findAll();

        return new WrapperResponse<>(true,"success",benefits)
                .createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Benefit>> register(@Validated @RequestBody Benefit benefit){
        return new WrapperResponse<>(true,"success",benefitService.save(benefit))
                .createResponse(HttpStatus.CREATED);
    }


    @PutMapping()
    public ResponseEntity<WrapperResponse<Benefit>> update (@Validated @RequestBody Benefit benefit){

        Benefit benefitFound = benefitService.findById(benefit.getId());

        if(benefitFound == null){
            throw new RecursoNoEncontrado("Benefit not found with ID: " + benefit.getId());
        }

        return new WrapperResponse<>(true,"success",benefitService.update(benefit))
                .createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> deleteById(@PathVariable("id") Integer id){

        Benefit benefitFound = benefitService.findById(id);

        if(benefitFound == null){
            throw new RecursoNoEncontrado("Benefit not found with ID: " + id);
        }

        benefitService.delete(id);

        return new WrapperResponse<Void>(true,"success",null)
                .createResponse(HttpStatus.NO_CONTENT);
    }
}
