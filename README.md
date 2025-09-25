# CRUD Usuario con JDBC

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
📂 Estructura del proyecto
bash
Copiar código
CrudUsuario_JDBC/
├── src/
│   ├── main/java/
│   │   ├── dao/         # Clases de acceso a datos
│   │   ├── model/       # Entidades del sistema
│   │   ├── util/        # Clase para conexión JDBC
│   │   └── Main.java    # Clase principal para ejecutar
├── lib/                 # Dependencias externas (si aplica)
└── README.md
▶️ Cómo ejecutar el proyecto
Clona el repositorio:

bash
Copiar código
git clone https://github.com/tu-usuario/CrudUsuario_JDBC.git
cd CrudUsuario_JDBC
Configura la conexión en la clase Conexion.java (o similar):

java
Copiar código
private static final String URL = "jdbc:mysql://localhost:3306/crud_usuarios";
private static final String USER = "root";
private static final String PASSWORD = "tu_contraseña";
Compila y ejecuta el proyecto desde tu IDE o terminal:

bash
Copiar código
javac -cp .;mysql-connector-j-8.0.xx.jar Main.java
java -cp .;mysql-connector-j-8.0.xx.jar Main
(Cambia la versión del conector MySQL según la que tengas en lib/)

🛠️ Funcionalidades
Crear usuario 👤

Listar usuarios 📋

Actualizar datos ✏️

Eliminar usuario ❌

📌 Notas
Asegúrate de tener el driver de MySQL (mysql-connector-j) en la carpeta lib/ o configurado como dependencia en Maven/Gradle.

Si usas WAMP/XAMPP, revisa el puerto (generalmente 3306).

✍️ Autor: Tu Nombre
📅 Año: 2025
