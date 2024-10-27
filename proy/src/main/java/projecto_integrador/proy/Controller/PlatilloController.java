package projecto_integrador.proy.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import projecto_integrador.proy.Model.Platillo;
import projecto_integrador.proy.Services.PlatilloService;
import java.util.List;

@Controller
public class PlatilloController {
    @Autowired
    private PlatilloService platilloService;

    //Cargar platillos.html"
    @GetMapping("/platillos")
    public String mostrarPlatillos(Model model, HttpSession session) {
        // Verificar si hay un usuario en la sesion
        if (session.getAttribute("usuario") != null) {
            model.addAttribute("usuario", session.getAttribute("usuario")); // Agrega el usuario al modelo
        }
        List<Platillo> platillos = platilloService.findAll(); // Obtener todos los platillos
        model.addAttribute("platillos", platillos); // Agregar platillos al modelo
        return "Platillos"; //Redirecciona a platillos.html
    }
}
