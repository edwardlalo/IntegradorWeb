package projecto_integrador.proy.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projecto_integrador.proy.Model.Platillo;
import projecto_integrador.proy.Repository.PlatilloRepository;
import java.util.List;

@Service
public class PlatilloService {

    @Autowired
    private PlatilloRepository platilloRepository;

    // Método para obtener todos los platillos
    public List<Platillo> findAll() {
        return platilloRepository.findAll();
    }
}