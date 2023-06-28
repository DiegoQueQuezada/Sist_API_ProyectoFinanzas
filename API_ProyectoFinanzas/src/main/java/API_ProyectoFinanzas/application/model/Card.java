package API_ProyectoFinanzas.application.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false, length = 20)
    @Size(min = 16, max = 19, message = "NroCard must be 16 characters")
    private String nroCard;

    private Boolean isEnable;

    @JsonBackReference
    @OneToOne(mappedBy = "card")
    private BankAccount bankAccount;
}
