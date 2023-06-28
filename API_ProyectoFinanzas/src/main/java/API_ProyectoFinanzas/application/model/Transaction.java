package API_ProyectoFinanzas.application.model;

import API_ProyectoFinanzas.enums.ETransaction;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity // este decorador te identica la clase y lo toma como entidad en la bd
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Positive(message = "Amount must be positive")
    private Double amount;

    @Enumerated(EnumType.STRING)
    private ETransaction operation;

    private LocalDateTime dateCreated;

    @ManyToOne
    @JoinColumn(name = "bank_account_id", nullable = false, foreignKey = @ForeignKey(name = "FK_bank_account_transaction"))
    private BankAccount bankAccount;

}
