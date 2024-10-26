package projecto_integrador.proy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projecto_integrador.proy.Model.IntranetUsu;

public interface IntranetUsuRepository extends JpaRepository<IntranetUsu, Integer> {
    // Puedes agregar métodos personalizados si es necesario
}
