package projecto_integrador.proy.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginIntranetController {

    @GetMapping("/intranetlogin")
    public String Intranetlogin() {
        return "Intranetlogin"; // Retorna la vista Login.html
    }
}
