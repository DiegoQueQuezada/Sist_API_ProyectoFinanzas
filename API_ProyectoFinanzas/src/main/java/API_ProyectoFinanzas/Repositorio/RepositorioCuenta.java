package API_ProyectoFinanzas.Repositorio;

import API_ProyectoFinanzas.Entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCuenta extends JpaRepository<Cuenta,Long> {
}
