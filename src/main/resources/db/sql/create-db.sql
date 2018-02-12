--DROP TABLE citizen IF EXISTS;

CREATE TABLE citizen (
  id      BIGINT PRIMARY KEY,
  contrasena VARCHAR(30),
  nombreUsuario  VARCHAR(50),
  dni VARCHAR(50),
  nombre VARCHAR(50),
  apellidos VARCHAR(50),
  fechaNacimiento DATE,
  email VARCHAR(50),
  direccionPostal VARCHAR(50),
  nacionalidad VARCHAR(50)
);
