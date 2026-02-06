# 📚 LiterAlura / BookSearch

Proyecto desarrollado como parte del desafío de programa ** Alura + Oracle ONE **
La aplicación permite consultar los libros desde una API externa (Gutendex), 
almacenar la información en una Base de Datos (PostgreSQL) y realizar consultas mediante interacción por consola.

----------

## 🚀 Fincuionalidades

✔️Buscar libros ppor Título usando la API Gutendex.

✔️Guardar libros y autores en base de datos PostgreSQL.

✔️Listar todos libros almacenados.

✔️Listar todos los autores.

✔️Consultar autores vivos en un año especifico.

✔️Listar libros por idiomas.

✔️Interacción completa mediante consola.

----------

## 🛠️ Tecnologías utilizadas

- **Java 17**
- **Spring Boot**
- **PostgreSQL**
- **Jackson**
- **Maven**
- **API Gutendex**

----------

## 🌐 API utilizada

**Gutendex**

URL base: https://gutendex.com/books/

----------

## 🗂️ Estructura del proyecto

src/main/java/com/alura/BoockSearch


├── model → Entidades y Records.

├── repository → Repositorios JPA.

├── service → Lógica de negocio.

├── api → Consumo de API.

└── BoockSearchApplication.java.

----------

## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio en IntelliJ terminal:
   ( ```bash
git clone https://github.com/DepearLegendari/LiterAlura.git )

2. Configurar PostgreSQL y variables de entorno:
spring.datasource.url=jdbc:postgresql://localhost/BookSearch
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD

----------

🧪 Ejemplo del menú en consola

1 - Buscar libro por título

2 - Listar libros

3 - Listar autores

4 - Autores vivos en un año

5 - Libros por idioma

0 - Salir

----------

📌 Observaciones

El proyecto guarda únicamente el primer idioma retornado por la API.

Cada libro se asocia a un solo autor.

Los autores vivos se identifican cuando el año de fallecimiento es null.
 
---------
Proyecto desarrollado por Iván Eduardo
Programa Oracle Next Education + Alura LATAM