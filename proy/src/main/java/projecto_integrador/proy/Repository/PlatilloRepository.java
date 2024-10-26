package projecto_integrador.proy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projecto_integrador.proy.Model.Platillo;

public interface PlatilloRepository extends JpaRepository<Platillo, Long> {
    // Puedes agregar métodos personalizados aquí si los necesitas
}