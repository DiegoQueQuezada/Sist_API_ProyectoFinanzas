package API_ProyectoFinanzas.infrastructure;

import API_ProyectoFinanzas.application.exception.RecursoNoEncontrado;
import API_ProyectoFinanzas.application.model.Transaction;
import API_ProyectoFinanzas.application.service.IBankAccountService;
import API_ProyectoFinanzas.application.service.ITransactionService;
import API_ProyectoFinanzas.application.util.WrapperResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    private final ITransactionService iTransactionService;
    private final IBankAccountService iBankAccountService;

    @GetMapping()
    public ResponseEntity<WrapperResponse<List<Transaction>>> findAll(){
        return new WrapperResponse<>(true,"success",iTransactionService.findAll())
                .createResponse(HttpStatus.OK);
    }

    @GetMapping("/historial/{id}")
    public ResponseEntity<WrapperResponse<List<Transaction>>> findAllByBankAccount(@PathVariable("id") Integer id){
        return new WrapperResponse<>(true,"success",iTransactionService.findAllByBankAccount(id))
                .createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Transaction>> register(@Validated @RequestBody Transaction transaction){

        if(iBankAccountService.findById(transaction.getBankAccount().getId()) == null){
            throw new RecursoNoEncontrado("Bank Account not found with ID: " + transaction.getBankAccount().getId());
        }

        return new WrapperResponse<>(true,"success",iTransactionService.save(transaction))
                .createResponse(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<WrapperResponse<Transaction>> update (@Validated @RequestBody Transaction transaction){

        Transaction transactionFound = iTransactionService.findById(transaction.getId());

        if(transactionFound == null){
            throw new RecursoNoEncontrado("Card not found with ID: " + transaction.getId());
        }

        return new WrapperResponse<>(true,"success",iTransactionService.update(transaction))
                .createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> deleteById(@PathVariable("id") Integer id){

        Transaction transactionFound = iTransactionService.findById(id);

        if(transactionFound == null){
            throw new RecursoNoEncontrado("Card not found with ID: " + id);
        }

        iTransactionService.delete(id);

        return new WrapperResponse<Void>(true,"success",null)
                .createResponse(HttpStatus.NO_CONTENT);
    }
}
