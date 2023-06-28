package API_ProyectoFinanzas.application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity // este decorador te identica la clase y lo toma como entidad en la bd
public class InvestmentUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_back_account", nullable = false, foreignKey = @ForeignKey(name = "FK_investment_investment_user"))
    private BankAccount bankAccount;

    @ManyToOne
    @JoinColumn(name = "id_invesment",  foreignKey = @ForeignKey(name = "FK_user_investment_user"))
    private Investment investment;

    private LocalDate startDate;

    private LocalDate endDate;

}
