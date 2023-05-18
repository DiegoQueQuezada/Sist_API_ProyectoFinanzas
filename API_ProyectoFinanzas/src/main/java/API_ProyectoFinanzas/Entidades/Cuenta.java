package API_ProyectoFinanzas.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="cuentas")
@Data   //Generar en tiempo de modificacion
@NoArgsConstructor  //Genere un constructor VACIO
@AllArgsConstructor //Genere un constructor con TODOS los atributos
@ToString
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombreUsuario",nullable = false)
    private String nombreUsuario;
    @Column(name="contraseña",nullable = false)
    private String contraseña;
    @Column(name="fotoURL",nullable = false)
    private String fotoURL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }
}



