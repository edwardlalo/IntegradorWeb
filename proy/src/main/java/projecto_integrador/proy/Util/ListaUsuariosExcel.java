package projecto_integrador.proy.Util;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import projecto_integrador.proy.Model.Usuario;

@Component
public class ListaUsuariosExcel extends AbstractXlsxView {

    @Override
protected void buildExcelDocument(@NonNull Map<String, Object> model, 
                                    @NonNull Workbook workbook,
                                    @NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response) throws Exception {
    try {
        //Establecer el nombre del archivo de descarga
        response.setHeader("Content-Disposition", "attachment; filename=\"listado_usuarios.xlsx\"");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        // Crear una nueva hoja de Excel
        Sheet hoja = workbook.createSheet("Usuarios");

        //Crear la fila de cabecera
        String[] columnas = {"ID", "Nombre", "Correo", "Contraseña"};
        Row filaCabecera = hoja.createRow(0);

        for (int i = 0; i < columnas.length; i++) {
            filaCabecera.createCell(i).setCellValue(columnas[i]);
        }

        //Recuperar la lista de usuarios desde el modelo
        @SuppressWarnings("unchecked")
        List<Usuario> usuarios = (List<Usuario>) model.get("usuarios");

        if (usuarios == null || usuarios.isEmpty()) {
            //Manejar el caso de usuarios vacíos
            Row fila = hoja.createRow(1);
            fila.createCell(0).setCellValue("No hay usuarios disponibles.");
            return;
        }

        // Crear filas para cada usuario
        int filaNum = 1;
        for (Usuario usuario : usuarios) {
            Row fila = hoja.createRow(filaNum++);
            fila.createCell(0).setCellValue(usuario.getId());
            fila.createCell(1).setCellValue(usuario.getNombre());
            fila.createCell(2).setCellValue(usuario.getCorreo());
            fila.createCell(3).setCellValue(usuario.getContrasena());
        }
    } catch (Exception e) {
        e.printStackTrace(); //Imprimir el error en la consola
        throw e; //O lanza la excepción para que sea manejada por Spring
    }
}

}
