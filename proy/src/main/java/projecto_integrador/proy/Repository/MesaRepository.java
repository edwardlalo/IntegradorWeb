package projecto_integrador.proy.Repository;

import projecto_integrador.proy.Model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, String> {
    // Métodos adicionales si es necesario
}
