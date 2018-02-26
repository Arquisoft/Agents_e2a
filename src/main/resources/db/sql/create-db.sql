--DROP TABLE agent IF EXISTS;

CREATE TABLE agent (
  id BIGINT PRIMARY KEY,
  contrasena VARCHAR(30),
  nombreUsuario  VARCHAR(50),
  kind VARCHAR(50),
  kindCode BIGINT,
  dni VARCHAR(50),
  nombre VARCHAR(50),
  apellidos VARCHAR(50),
  email VARCHAR(50)
);
