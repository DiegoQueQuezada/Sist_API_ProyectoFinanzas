package API_ProyectoFinanzas.application.model;

import API_ProyectoFinanzas.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Entity // este decorador te identica la clase y lo toma como entidad en la bd
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "FK_user_bank_account"))
    private User user;

    @PositiveOrZero(message = "El monto debe ser positivo")
    @NotNull(message = "El monto no puede ser nulo")
    private Double amount;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "id_card", foreignKey = @ForeignKey(name = "FK_card_bank_account"))
    private Card card;

    private LocalDate dateCreated;

    public void deposit(Double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo");
        }
        this.amount += amount;
    }

    public void withdraw(Double amountToWithdraw) {
        if (amountToWithdraw > this.amount) {
            throw new IllegalArgumentException("No tienes suficiente saldo para retirar");
        }
        if (amountToWithdraw < 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        this.amount -= amountToWithdraw;
    }
}
