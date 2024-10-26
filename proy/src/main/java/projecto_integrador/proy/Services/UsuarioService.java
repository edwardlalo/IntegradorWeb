package projecto_integrador.proy.Services;

import projecto_integrador.proy.Model.Usuario;

import java.util.List;

public interface UsuarioService {
    void save(Usuario usuario);
    Usuario findByCorreo(String correo);
    List<Usuario> findAll();
}
