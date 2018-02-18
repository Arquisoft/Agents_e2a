[![Codacy Badge](https://api.codacy.com/project/badge/Grade/62678ef56d424b1cb7b719e3d279ba67)](https://www.codacy.com/app/jelabra/Agents_e2a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/Agents_e2a&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Arquisoft/Agents_e2a.svg?branch=master)](https://travis-ci.org/Arquisoft/Agents_e2a)
[![codecov](https://codecov.io/gh/Arquisoft/Agents_e2a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/Agents_e2a)


# Agents2a


Agents e2a

# Previous Authors

- Herminio García González (@herminiogg)
- Jose Emilio Labra Gayo (@labra)
- Sergio Flórez Vallina (@zerolfer)
- Rubén García Ruiz (@RubenGarciaR)
- Sonia Gestal Huelga (@sonia94)
- Luis Irazusta Lorenzo (@Fuegon)

# Actual Authors

- Jose Emilio Labra Gayo (@labra)
- Jesus García Minas (@jesusgarciaminas)
- Pelayo García Torre (@Pelayo-Torre)
- José Antonio García García (@MrKarrter)

# Funcionamiento:
## Interfaz HTML
1. Escribir en el navegador: http://localhost:8080/
2. Proporcionar los datos de login para los usuarios disponibles:
 * Login: juan, pedro, raul
 * Password: 1234
 * Kind: Person, Entity, Sensor (Respectivamente)
3. Aparecerá la pantalla que muestra los datos del usuario
 * Se puede modificar el email (se comprueba si el email es valido)
 * Se puede ir a la pantalla de cambio de contraseña
4. Cambio de contraseña:
 * Escribir la contreseña antigua
 * Escribir la nueva contraseña

## Servicio REST
   El punto de entrada se encuentra en http://localhost:8080/info.
   
   Acepta peticiones POST en formato JSON con el contenido:
   ``{"login":"login_usuario", "password":"contraseña_usuario", "kind":"tipo_usuario"}``
   
   Si los datos no son correctos se devuelve un error HTTP 404.
   Si los parametros no son correctos se devuelve un codigo de error HTTP 406.
   
### Formato de retorn JSON
   ```json
   {
      "id": id_usuario (long),
      "name": "nombre_usuario",
      "surname": "apellido_usuario",
      "email": "email",
      "kind": "tipo_usuario",
      "kindCode": id_kind (long),
      "location": "localizacion_usuario" (Location)
   }
   ```


