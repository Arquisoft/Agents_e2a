[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2f5e9b234d9b4cbd8669629c299990ad)](https://www.codacy.com/app/jelabra/participants2a?utm_source=github.com&utm_medium=referral&utm_content=Arquisoft/participants2a&utm_campaign=badger)
[![Build Status](https://travis-ci.org/Arquisoft/participants2a.svg?branch=master)](https://travis-ci.org/Arquisoft/participants2a)
[![codecov](https://codecov.io/gh/Arquisoft/participants2a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/participants2a)


# participants2a

[![Join the chat at https://gitter.im/Arquisoft/participants2a](https://badges.gitter.im/Arquisoft/participants2a.svg)](https://gitter.im/Arquisoft/participants2a?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Skeleton of participants module

# Authors

- Herminio García González (@herminiogg)
- Jose Emilio Labra Gayo (@labra)
- Sergio Flórez Vallina (@zerolfer)
- Rubén García Ruiz (@RubenGarciaR)
- Sonia Gestal Huelga (@sonia94)
- Luis Irazusta Lorenzo (@Fuegon)

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
   


