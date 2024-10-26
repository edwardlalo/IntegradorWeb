package projecto_integrador.proy.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projecto_integrador.proy.Model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
    // Puedes agregar métodos personalizados aquí si los necesitas
}
