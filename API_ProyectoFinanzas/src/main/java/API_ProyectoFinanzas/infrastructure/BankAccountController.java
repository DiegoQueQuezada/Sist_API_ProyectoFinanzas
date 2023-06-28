package API_ProyectoFinanzas.infrastructure;

import API_ProyectoFinanzas.application.exception.RecursoNoEncontrado;
import API_ProyectoFinanzas.application.model.BankAccount;
import API_ProyectoFinanzas.application.service.IBankAccountService;
import API_ProyectoFinanzas.application.util.WrapperResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/bank-account")
@RestController
public class BankAccountController {

    private final IBankAccountService bankAccountService;

    @PostMapping
    public ResponseEntity<WrapperResponse<BankAccount>> register(@Validated @RequestBody BankAccount bankAccount){
        System.out.println(bankAccount);
        return new WrapperResponse<>(true,"success",bankAccountService.register(bankAccount))
                .createResponse(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<WrapperResponse<List<BankAccount>>> findAll() {
        List<BankAccount> accounts = bankAccountService.findAll();

        return new WrapperResponse<>(true,"success",accounts)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<WrapperResponse<BankAccount>> update (@Validated @RequestBody BankAccount bankAccount){

        BankAccount bankAccountFound = bankAccountService.findById(bankAccount.getId());

        if(bankAccountFound == null){
            throw new RecursoNoEncontrado("Bank Account not found with ID: " + bankAccount.getId());
        }

        return new WrapperResponse<>(true,"success",bankAccountService.update(bankAccount))
                .createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> deleteById(@PathVariable("id") Integer id){

        BankAccount bankAccountFound = bankAccountService.findById(id);

        if(bankAccountFound == null){
            throw new RecursoNoEncontrado("Bank Account not found with ID: " + id);
        }

        bankAccountService.deleteById(id);

        return new WrapperResponse<Void>(true,"success",null)
                .createResponse(HttpStatus.NO_CONTENT);
    }
}
