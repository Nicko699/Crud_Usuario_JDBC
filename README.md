# CRUD Usuario con JDBC.

Este proyecto es un **CRUD (Crear, Leer, Actualizar y Eliminar) de usuarios** desarrollado en **Java** utilizando **JDBC** para la conexión con base de datos MySQL.  

## 📋 Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- [Java JDK 17+](https://adoptium.net/)  
- [MySQL 8+](https://dev.mysql.com/downloads/)  
- [WAMP/XAMPP o MySQL Server](https://www.apachefriends.org/es/index.html)  
- [Maven](https://maven.apache.org/) (si usas dependencias)  
- Un IDE como **IntelliJ IDEA**, **Eclipse** o **NetBeans**  

## ⚙️ Configuración de la base de datos

1. Inicia tu servidor MySQL.  
2. Crea la base de datos:

```sql
CREATE DATABASE crud_usuarios;
Usa la base de datos y crea la tabla usuarios:

sql
Copiar código
USE crud_usuarios;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    clave VARCHAR(100) NOT NULL
);

▶️ Cómo ejecutar el proyecto
Clona el repositorio:

bash
Copiar código
git clone https://github.com/tu-usuario/CrudUsuario_JDBC.git
cd CrudUsuario_JDBC
Configura la conexión en la clase Conexion.java (o similar):

java
Copiar código
Nota:este código funciona si en la bd que ustedes crean la id de la entidad se crea automaticamente
Nota2: En la bd del proyecto si hay un usuario:rooot y contraseña=123, por favor cambiarla si va a probar este código
Nota3:Asegurense de tener el mismo nombre de la bd crud_usuario_jdbc

 String url= "jdbc:mysql://localhost:3306/crud_usuarios";
 String usuario = "tu usuario";
 String password = "tu contraseña";
Compila y ejecuta el proyecto desde tu IDE o terminal:

🛠️ Funcionalidades
Crear usuario 👤

Listar usuarios 📋

Actualizar datos ✏️

Eliminar usuario ❌

📌 Notas
Asegúrate de tener el driver de MySQL (mysql-connector-j) en la carpeta lib/ o configurado como dependencia en Maven/Gradle.

Si usas WAMP/XAMPP, revisa el puerto (generalmente 3306).


