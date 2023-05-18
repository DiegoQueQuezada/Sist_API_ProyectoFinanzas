package API_ProyectoFinanzas.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="transaccion")
@Data   //Generar en tiempo de modificacion
@NoArgsConstructor  //Genere un constructor VACIO
@AllArgsConstructor //Genere un constructor con TODOS los atributos
@ToString
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "monto",nullable = false,scale = 2)
    private double monto;
    @Column(name = "fechaT",nullable = false,scale = 2)
    private String fechaT;
    @ManyToOne
    @JoinColumn(name = "id_Cuenta",nullable = false)
    private Cuenta cuenta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFechaT() {
        return fechaT;
    }

    public void setFechaT(String fechaT) {
        this.fechaT = fechaT;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
