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
3. Aparecerá la pantalla que muestra los datos del usuario
 * Se puede modificar el email (se comprueba si el email es valido)
 * Se puede ir a la pantalla de cambio de contraseña
4. Cambio de contraseña:
 * Escribir la contreseña antigua
 * Escribir la nueva contraseña

## Servicio REST
   El punto de entrada se encuentra en http://localhost:8080/user.
   
   Acepta peticiones POST en formato JSON con el contenido:
   ``{"login":"login_usuario", "password":"contraseña_usuario"}``
   
   Devuelve la informacion del usuario si las credenciales en formato 
   JSON o XML segun se indique en la cabecera de la petición.
   
   Si los datos no son correctos se devuelve un error HTTP 404.
   Si los parametros no son correctos se devuelve un codigo de error HTTP 406.
   
### Formato de retorn JSON
   ```json
   {
     "firstName": "nombre",
     "lastName": "apellidos",
     "edad": edad(int),
     "id": id_usuario(long),
     "email": "email",
     "address": "direccion",
     "nationality": "nacionalidad"
   }
   ```
### Formato retorno XML
   ```xml
   <CitizenMin>
       <firstName>nombre</firstName>
       <lastName>apellidos</lastName>
       <edad>edad</edad>
       <id>id_usuario</id>
       <email>email</email>
       <address>direccion</address>
       <nationality>nacionalidad</nationality>
   </CitizenMin>
   ```
   


