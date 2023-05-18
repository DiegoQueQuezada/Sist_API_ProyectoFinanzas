package API_ProyectoFinanzas.Controladores;

import API_ProyectoFinanzas.Entidades.Cuenta;
import API_ProyectoFinanzas.Servicios.ServicioCuentas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/v1/cuentas")
public class ControladorCuenta {

    private final ServicioCuentas sc;

    public ControladorCuenta(ServicioCuentas s) {
        this.sc = s;
    }
    @GetMapping
    public ResponseEntity<List<Cuenta>> obtenerListaCuentas(@RequestBody Cuenta c ){
        return new ResponseEntity<List<Cuenta>>(sc.obtenerTodasLasCuentas(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Cuenta> agregarCuenta(@RequestBody Cuenta c){
        return new ResponseEntity<Cuenta>(sc.crearCuenta(c),HttpStatus.CREATED);
    }
}
