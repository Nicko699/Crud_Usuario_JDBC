package org.CrudUsuario_JDBC;

import org.CrudUsuario_JDBC.Dto.UsuarioRequestDto;
import org.CrudUsuario_JDBC.Service.UsuarioService;
import org.CrudUsuario_JDBC.Service.UsuarioServiceImpl;
import java.util.Scanner;

public class Main {
//Nota: este código funciona si en la bd que ustedes crean la id de la entidad se crea automaticamente
    public static void main(String[] args) {

        UsuarioService usuarioService = new UsuarioServiceImpl();

        //Nota: En mi bd si le tengo un usuario:rooot y contraseña=123, por favor cambiarla si va a probar este código
        String usuario = "rooot";
        String password = "123";
        //Asegurense de tener el mismo nombre de la bd crud_usuario_jdbc
        String url = "jdbc:mysql://localhost:3306/crud_usuario_jdbc?serverTimezone=UTC";

        usuarioService.establecerConexion(usuario, password, url);

        Scanner teclado = new Scanner(System.in);

        int opcion;

        while (true) {
            while (true) {
                System.out.println("Selecione alguna de las siguientes opciones:");
                System.out.println("1.Consultar usuario");
                System.out.println("2.Consultar todos los usuarios");
                System.out.println("3.Crear usuario");
                System.out.println("4.Editar usuario");
                System.out.println("5.Eliminar usuario");
                System.out.println("6.Salir");
                if (teclado.hasNextInt()) {
                    opcion = teclado.nextInt();
                    teclado.nextLine();
                    break;
                } else {
                    System.out.println("Solo se puede ingresar numeros del (1-6)");
                    teclado.nextLine();
                }
            }

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el id del usuario a consultar");
                    int idUsuario = teclado.nextInt();

                    usuarioService.encontrarUsuario(idUsuario);
                    break;

                case 2:
                    usuarioService.encontrarUsuarios();
                    break;

                case 3:
                    int edad;
                    System.out.println("Ingrese el nombre del nuevo usuario");
                    String nombre = teclado.nextLine();

                    System.out.println("Ingrese el apellido del nuevo usuario");
                    String apellido = teclado.nextLine();

                    while (true) {
                        System.out.println("Ingrese la edad del nuevo usuario");
                        if (teclado.hasNextInt()) {
                            edad = teclado.nextInt();
                            teclado.nextLine();
                            break;
                        } else {
                            System.out.println("Por favor. Ingrese la edad correcta");
                            teclado.nextLine();
                        }
                    }

                    System.out.println("Ingrese el correo del nuevo usuario");
                    String correo = teclado.nextLine();

                    UsuarioRequestDto usuarioRequestDto = new UsuarioRequestDto(nombre, apellido, edad, correo);

                    usuarioService.crearUsuario(usuarioRequestDto);
                    break;

                case 4:
                    int nuevaEdad;
                    int id;

                    while (true) {
                        System.out.println("Ingrese el ID del usuario a editar");
                        if (teclado.hasNextInt()) {
                            id = teclado.nextInt();
                            teclado.nextLine();
                            break;
                        } else {
                            System.out.println("Por favor. Ingrese un ID válido");
                            teclado.nextLine();
                        }
                    }

                    System.out.println("Ingrese el nuevo nombre del usuario");
                    String nuevoNombre = teclado.nextLine();

                    System.out.println("Ingrese el nuevo apellido del usuario");
                    String nuevoApellido = teclado.nextLine();

                    while (true) {
                        System.out.println("Ingrese la edad del nuevo usuario");
                        if (teclado.hasNextInt()) {
                            nuevaEdad = teclado.nextInt();
                            teclado.nextLine();
                            break;
                        } else {
                            System.out.println("Por favor. Ingrese la edad correcta");
                            teclado.nextLine();
                        }
                    }

                    System.out.println("Ingrese el nuevo correo del usuario");
                    String nuevoCorreo = teclado.nextLine();

                    usuarioService.editarUsuario(id, nuevoNombre, nuevoApellido, nuevaEdad, nuevoCorreo);
                    break;

                case 5:
                    System.out.println("Ingrese el id del usuario a eliminar");
                    int usuarioId = teclado.nextInt();

                    usuarioService.eliminarUsuario(usuarioId);
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Por favor seleccione una opción válida (1-6)");
                    break;
            }
        }
    }
}