package org.CrudUsuario_JDBC.Service;

import org.CrudUsuario_JDBC.Dto.UsuarioRequestDto;

public interface UsuarioService {

    public void establecerConexion(String usuario, String password, String url);

    public void encontrarUsuario(int id);

    public void encontrarUsuarios();

    public void crearUsuario(UsuarioRequestDto usuarioRequestDto);

    public void editarUsuario(int id, String nombre, String apellido, int edad, String correo);

    public void eliminarUsuario(int id);

    public boolean existeUsuario(int id);
}
