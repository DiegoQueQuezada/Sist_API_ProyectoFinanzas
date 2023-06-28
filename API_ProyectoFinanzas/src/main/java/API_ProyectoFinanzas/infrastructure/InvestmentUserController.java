package API_ProyectoFinanzas.infrastructure;

import API_ProyectoFinanzas.application.exception.RecursoNoEncontrado;
import API_ProyectoFinanzas.application.model.InvestmentUser;
import API_ProyectoFinanzas.application.service.IInvestmentUserService;
import API_ProyectoFinanzas.application.util.WrapperResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/investmentUser")
public class InvestmentUserController {

    private final IInvestmentUserService iInvestmentUserService;

    @GetMapping()
    public ResponseEntity<WrapperResponse<List<InvestmentUser>>> findAll() {
        List<InvestmentUser> investmentUser = iInvestmentUserService.findAll();

        return new WrapperResponse<>(true,"success",investmentUser)
                .createResponse(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<WrapperResponse<InvestmentUser>> createProduct(@RequestBody InvestmentUser investmentUser) {
        return new WrapperResponse<>(true, "success", iInvestmentUserService.save(investmentUser))
                .createResponse(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<WrapperResponse<InvestmentUser>> update (@Validated @RequestBody InvestmentUser investmentUser){

        InvestmentUser investmentUserFound = iInvestmentUserService.findById(investmentUser.getId());

        if(investmentUserFound == null){
            throw new RecursoNoEncontrado("Benefit not found with ID: " + investmentUser.getId());
        }

        return new WrapperResponse<>(true,"success",iInvestmentUserService.update(investmentUser))
                .createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> deleteById(@PathVariable("id") Integer id){

        InvestmentUser investmentUserFound = iInvestmentUserService.findById(id);

        if(investmentUserFound == null){
            throw new RecursoNoEncontrado("Benefit not found with ID: " + id);
        }

        iInvestmentUserService.delete(id);

        return new WrapperResponse<Void>(true,"success",null)
                .createResponse(HttpStatus.NO_CONTENT);
    }
}
