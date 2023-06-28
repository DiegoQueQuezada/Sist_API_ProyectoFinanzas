package API_ProyectoFinanzas.infrastructure;

import API_ProyectoFinanzas.application.exception.RecursoNoEncontrado;
import API_ProyectoFinanzas.application.model.FinancialConsulting;
import API_ProyectoFinanzas.application.service.IFinancialConsultingService;
import API_ProyectoFinanzas.application.util.WrapperResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/financial-consulting")
public class FinancialConsultingController {

    private final IFinancialConsultingService financialConsultingService;

    @GetMapping()
    public ResponseEntity<WrapperResponse<List<FinancialConsulting>>> findAll() {
        List<FinancialConsulting> financialConsultings = financialConsultingService.findAll();

        return new WrapperResponse<>(true,"success",financialConsultings)
                .createResponse(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<WrapperResponse<FinancialConsulting>> register(@Validated @RequestBody FinancialConsulting financialConsulting){
        System.out.println(financialConsulting);
        return new WrapperResponse<>(true,"success",financialConsultingService.save(financialConsulting))
                .createResponse(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<WrapperResponse<FinancialConsulting>> update (FinancialConsulting financialConsulting){

        FinancialConsulting financialConsultingFound = financialConsultingService.findById(financialConsulting.getId());

        if(financialConsultingFound == null){
            throw new RecursoNoEncontrado("FinancialConsulting not found with ID: " + financialConsulting.getId());
        }

        return new WrapperResponse<>(true,"success",financialConsultingService.update(financialConsulting))
                .createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> deleteById(@PathVariable("id") Integer id){

        FinancialConsulting financialConsultingFound = financialConsultingService.findById(id);

        if(financialConsultingFound == null){
            throw new RecursoNoEncontrado("FinancialConsulting not found with ID: " + id);
        }

        financialConsultingService.delete(id);

        return new WrapperResponse<Void>(true,"success",null)
                .createResponse(HttpStatus.NO_CONTENT);
    }
}
