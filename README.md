[![Codacy Badge](https://api.codacy.com/project/badge/Grade/62678ef56d424b1cb7b719e3d279ba67)](https://www.codacy.com/app/jelabra/Agents_e2a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/Agents_e2a&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Arquisoft/Agents_e2a.svg?branch=master)](https://travis-ci.org/Arquisoft/Agents_e2a)
[![codecov](https://codecov.io/gh/Arquisoft/Agents_e2a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/Agents_e2a)


# Agents2a

Acceso al repositorio común del grupo Inci_E2:
https://github.com/Arquisoft/Inci_e2a

Acceso al subgrupo encargado del Loader_E2:
https://github.com/Arquisoft/loader_e2a

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
## Servicio REST
### Opción 1
   - Utilizamos la versión de Agents desplegada en la siguiente dirección: http://35.180.34.205:8070/info

### Opción 2
   - Lanzamos la aplicación mediante el comando mvn spring-boot:run
   - El punto de entrada se encuentra en http://localhost:8070/info.
   
   Acepta peticiones POST en formato JSON con el contenido:
   ``{"login":"login_usuario", "password":"contraseña_usuario", "kind":"tipo_usuario"}``
   
   Si los datos no son correctos se devuelve un error HTTP NOT_FOUND.
   Si los parametros no son correctos se devuelve un codigo de error HTTP BAD_REQUEST.
   
### Formato de retorn JSON
   ```json
   {
      "id": "id_usuario" (long),
      "password": "password",
      "kind": "tipo_usuario",
      "kindCode": "id_kind" (long),
      "dni": "dni",
      "nombre": "nombre",
      "apellidos": "apellidos",
      "email": "email",
      "username": "nombre_usuario"
   }
   ```


