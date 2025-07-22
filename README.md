# ForoHub

Aplicación de foro desarrollada en Java con Spring Boot, que permite la comunicación y discusión entre usuarios mediante la creación de temas y respuestas, con autenticación segura mediante JWT.

---

## ⚙️ Características principales

- Registro y autenticación de usuarios (login con JWT).
- CRUD de temas (tópicos): creación, edición, eliminación y listado.
- Respuestas a temas existentes.
- Listado de usuarios registrados.
- Seguridad con Spring Security + JWT.
- Documentación automática de la API con Swagger.
- Base de datos en memoria (H2) para desarrollo, fácilmente configurable a MySQL.

---

## 🛠️ Tecnologías

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- JPA / Hibernate
- Base de datos MYSQL
- Swagger
- Postman (para pruebas)

---

## 📁 Estructura del proyecto

src/


└─ main/


├─ java/


│ └─ com.tuempresa.forohub/


│ ├─ controller/ ← Controladores REST


│ ├─ service/ ← Lógica de negocio


│ ├─ repository/ ← Repositorios JPA


│ ├─ model/ ← Entidades & DTOs


│ └─ security/ ← Configuración de seguridad JWT


└─ resources/


├─ application.properties ← Configuración de datos y entorno


└─ swagger-config.xml ← Opcional, configuración de Swagger


---

## 🚀 Instalación & Ejecución

1. Clonar el repositorio  
   ```bash
   git clone https://github.com/Juan392/foroHub.git
Entrar al directorio del proyecto

cd foroHub

Compilar y ejecutar con Maven


mvn spring-boot:run

Ajusta las credenciales en src/main/resources/application.properties:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/forohub

spring.datasource.username=TU_USUARIO

spring.datasource.password=TU_CONTRASEÑA

spring.jpa.hibernate.ddl-auto=update

Accede a:

API: http://localhost:8080/

Swagger UI: http://localhost:8080/swagger-ui/index.html

🧩 Endpoints principales


Método|	Ruta	|Descripción	Autenticación
------------------------------------------
POST|	/login	|Login de usuario, retorna JWT	❌
------------------------------------------
POST|	/usuarios	|Registrar nuevo usuario	❌
--
GET|	/usuarios	|Obtener lista de usuarios	✅ (JWT)
--
GET|	/topicos	|Listar tópicos	✅ (JWT)
--
POST|	/topicos	|Crear un nuevo tópico	✅ (JWT)
--
PUT|	/topicos/{id}	|Editar un tópico existente	✅ (JWT)
--
DELETE|	/topicos/{id}	|Eliminar un tópico	✅ (JWT)
--

🧪 Pruebas
Se recomienda Postman (o similar) para probar los endpoints. Puedes crear una colección propia o importar una basada en los endpoints anteriores.

📝 Contribuciones
¡Son bienvenidas! Abre un Issue para proponer mejoras o reportar errores. Realiza un fork y envía un Pull Request.

🛡️ Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más información.

📌 Sobre
Versión derivada del challenge Foro Hub con Spring Boot. Basado en el repositorio original de Orliluq (github.com).

---
