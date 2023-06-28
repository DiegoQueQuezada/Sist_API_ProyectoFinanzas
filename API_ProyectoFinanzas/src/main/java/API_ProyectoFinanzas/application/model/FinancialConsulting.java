package API_ProyectoFinanzas.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity // este decorador te identica la clase y lo toma como entidad en la bd
public class FinancialConsulting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El titulo es obligatorio")
    @Size(min = 3, message = "El titulo debe tener minimo 3 caracteres")
    private String title;

    @Size(min = 10, message = "El contenido debe tener minimo 10 caracteres")
    private String content;

    private String url;
}
