package projecto_integrador.proy.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import projecto_integrador.proy.Model.Personal;

@Controller
public class IntranetController {

    @GetMapping("/intranet")
    public String mostrarIntranet(HttpSession session, Model model) {
        Personal usuarioLogueado = (Personal) session.getAttribute("usuarioLogueado");

        if (usuarioLogueado != null) {
            // Pasar todos los datos del usuario al modelo
            model.addAttribute("nombre", usuarioLogueado.getNombre());
            model.addAttribute("apellido", usuarioLogueado.getApellido());
            model.addAttribute("correo", usuarioLogueado.getCorreo());
            model.addAttribute("puesto", usuarioLogueado.getPuesto());
            model.addAttribute("telefono", usuarioLogueado.getTelefono());
            model.addAttribute("direccion", usuarioLogueado.getDireccion());
            model.addAttribute("genero", usuarioLogueado.getGenero());
            
            return "intranet"; // Redirige a la página de intranet
        } else {
            return "redirect:/intranetlogin"; // Si no hay sesión, redirige a login
        }
    }
    // Método para manejar el logout
}
