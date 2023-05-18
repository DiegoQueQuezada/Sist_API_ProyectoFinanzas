package API_ProyectoFinanzas.Servicios;

import API_ProyectoFinanzas.Entidades.Cuenta;
import API_ProyectoFinanzas.Repositorio.RepositorioCuenta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCuentas {

    private final RepositorioCuenta repCuenta;

    public ServicioCuentas(RepositorioCuenta repCuenta) {
        this.repCuenta = repCuenta;
    }

    public Cuenta crearCuenta(Cuenta c){
        return  repCuenta.save(c);
    }
    public List<Cuenta> obtenerTodasLasCuentas(){
        return repCuenta.findAll();
    }

}
