package projecto_integrador.proy.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import projecto_integrador.proy.Model.Mesa;
import projecto_integrador.proy.Services.MesaService;

import java.util.List;

@Controller
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping("/reservaMesas")
    public String mostrarMesas(Model model, HttpSession session) {
        // Verificar si hay un usuario en la sesión
        if (session.getAttribute("usuario") != null) {
            model.addAttribute("usuario", session.getAttribute("usuario"));
        }

        // Obtener todas las mesas de la base de datos
        List<Mesa> mesas = mesaService.obtenerMesas();
        model.addAttribute("mesas", mesas);
        
        return "ReservaMesas";
    }

    @PostMapping("/guardarMesasSeleccionadas")
    @ResponseBody
    public String guardarMesasSeleccionadas(@RequestBody List<String> mesasSeleccionadas, HttpSession session) {
        // Guardar las mesas seleccionadas en la sesión
        session.setAttribute("mesasSeleccionadas", mesasSeleccionadas);
        return "success";
    }
}
