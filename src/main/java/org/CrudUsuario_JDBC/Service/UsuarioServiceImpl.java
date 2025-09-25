package org.CrudUsuario_JDBC.Service;

import org.CrudUsuario_JDBC.Dto.UsuarioRequestDto;

import java.sql.*;

public class UsuarioServiceImpl implements UsuarioService {

    Connection connection;

    @Override
    public void establecerConexion(String usuario, String password, String url) {
        try {
            connection = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void encontrarUsuario(int id) {

        String sql = "SELECT * FROM usuario WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {

                if (rs.next()) {
                    System.out.println("id: " + rs.getInt("id"));
                    System.out.println("nombre: " + rs.getString("nombre"));
                    System.out.println("apellido: " + rs.getString("apellido"));
                    System.out.println("edad: " + rs.getInt("edad"));
                    System.out.println("correo: " + rs.getString("correo"));
                    System.out.println("--------------------");
                } else {
                    System.out.println("No se encontró un usuario con el id:" + id);
                }

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void encontrarUsuarios() {
        String sql = "SELECT * FROM usuario";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {

                System.out.println("id: " + rs.getString("id"));
                System.out.println("nombre: " + rs.getString("nombre"));
                System.out.println("apellido: " + rs.getString("apellido"));
                System.out.println("edad: " + rs.getInt("edad"));
                System.out.println("correo: " + rs.getString("correo"));
                System.out.println("--------------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crearUsuario(UsuarioRequestDto usuarioRequestDto) {

        String sql = "INSERT INTO usuario (nombre, apellido, edad, correo) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, usuarioRequestDto.getNombre());
            preparedStatement.setString(2, usuarioRequestDto.getApellido());
            preparedStatement.setInt(3, usuarioRequestDto.getEdad());
            preparedStatement.setString(4, usuarioRequestDto.getEmail());

            preparedStatement.executeUpdate();

            try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    int idEncontrado = rs.getInt(1);

                    encontrarUsuario(idEncontrado);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void editarUsuario(int id, String nombre, String apellido, int edad, String correo) {

        String sqlUpdate = "UPDATE usuario SET nombre = ?, apellido = ?, edad = ?, correo = ? WHERE id = ?";

        if (existeUsuario(id)) {

            try (PreparedStatement prepared = connection.prepareStatement(sqlUpdate)) {
                prepared.setString(1, nombre);
                prepared.setString(2, apellido);
                prepared.setInt(3, edad);
                prepared.setString(4, correo);
                prepared.setInt(5, id);

                prepared.executeUpdate();
                System.out.println("Usuario actualizado correctamente.");
                encontrarUsuario(id);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No se encontró un usuario con el ID: " + id);
        }

    }

    @Override
    public void eliminarUsuario(int id) {

        String sqlDelete = "DELETE FROM usuario WHERE id = ?";

        if (existeUsuario(id)) {

            try (PreparedStatement prepared = connection.prepareStatement(sqlDelete)) {
                prepared.setInt(1, id);
                prepared.executeUpdate();
                System.out.println("Usuario eliminado con éxito.");
                encontrarUsuarios();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No existe un usuario con el ID: " + id);
        }

    }

    @Override
    public boolean existeUsuario(int id) {
        String sqlSelect = "SELECT * FROM usuario WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
