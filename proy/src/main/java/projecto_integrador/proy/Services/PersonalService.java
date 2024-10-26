package projecto_integrador.proy.Services;

import projecto_integrador.proy.Model.Personal;

import java.util.List;

public interface PersonalService {
    void save(Personal personal);
    Personal findByCorreo(String correo);
    List<Personal> findAll();
}
