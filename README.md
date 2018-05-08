# Agents_e2a #

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/62678ef56d424b1cb7b719e3d279ba67)](https://www.codacy.com/app/jelabra/Agents_e2a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/Agents_e2a&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Arquisoft/Agents_e2a.svg?branch=master)](https://travis-ci.org/Arquisoft/Agents_e2a)
[![codecov](https://codecov.io/gh/Arquisoft/Agents_e2a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/Agents_e2a)

Este repositorio contiene el código de uno de los submódulos del proyecto: Gestión de Incidencias de la asignatura Arquitectura del Software del grado Ingeniería Informática del Software. Para ver más información visite el [repositorio principal](https://github.com/Arquisoft/inci_e2a).

## AUTORES 2017-2018 ##

La versión que contiene este repositorio fue ampliada por los siguientes usuarios:
+ Jesús García Minas.
> [@JesusGarciaMinas](https://github.com/JesusGarciaMinas)

> UO250999

+ Pelayo García Torre.
> [@Pelayo-Torre](https://github.com/Pelayo-Torre)

> UO251143

+ José Antonio García García.
> [@MrKarrter](https://github.com/MrKarrter)

> UO251317

## AUTORES 2016-2017 ##

La versión inicial del proyecto corre a cargo de los siguientes usuarios:

* Herminio García González (@herminiogg)
* Jose Emilio Labra Gayo (@labra)
* Sergio Flórez Vallina (@zerolfer)
* Rubén García Ruiz (@RubenGarciaR)
* Sonia Gestal Huelga (@sonia94)
* Luis Irazusta Lorenzo (@Fuegon)
- - - -

## Introducción al repositorio ##

Este repositorio pertenece a la parte *Agents* del grupo de trabajo **E2A**, encargada de comprobar si las peticiones REST que recibe concuerdan con agentes registrados en el sistema. También ofrece un servicio web que permite a los agentes modificar su contraseña.

## Como probar el proyecto ##
Los pasos a seguir en esta guía están preparados para ser ejecutados en una maquina con un sistema operativo Windows. En el caso de querer probarlo en una maquina Linux, compruebe el repositorio [inicial](https://github.com/Arquisoft/inci_e2a).

Lo primero es comprobar que tenemos una versión de Java y Maven funcionando en el sistema. Para ello vamos a abrir un terminal del sistema:
1.	Presionamos en las teclas Windows + R.
2.	En la ventana que se abre escribimos: *cmd* y damos a la tecla Intro.
3.	Una vez abierto el terminal escribimos esta orden y nos debería mostrar algo similar a la imagen de la izquierda.
```bash
java -version
```
4.	Despues escribimos esta otra orden y nos debería mostrar algo similar a la imagen de la derecha.
```bash
mvn -version
```
![versiones](https://github.com/Arquisoft/inci_e2a/blob/master/readme_imagenes/Version_Java_Maven.png)
En el caso de que esto no funcione, vuelva a instalar Java o Maven y pruebe de nuevo.

Ahora nos descargaremos la versión zip del repositorio:
![descargar_zip](https://github.com/Arquisoft/inci_e2a/blob/master/readme_imagenes/Descarga_Agents.png)

Descomprimimos el archivo, lo que nos creará una carpeta con el mismo nombre. 
![zip](https://github.com/Arquisoft/inci_e2a/blob/master/readme_imagenes/Zip_Agents.png)

Una vez dentro hacemos clic en el explorador de archivos y escribimos *cmd* lo que nos abrirá un terminal del sistema en la ruta actual.
Para asegurarnos de que se están creado bien las dependencias del proyecto, vamos a comprobar previamente el correcto funcionamiento de las pruebas con la orden:
```bash
mvn test
```
Este proceso tardará alrededor de 30 segundos en completarse y, si todo ha ido bien, debería aparecer algo similar a la siguiente imagen:
![test](https://github.com/Arquisoft/inci_e2a/blob/master/readme_imagenes/Test_Agents.png)

Ahora vamos a ejecutar la aplicación. Para ello vamos a ejecutar el comando:
```bash
mvn spring-boot:run"
```
Tras unos 15 segundos, veremos una imagen similar a la siguiente que nos indicará que la aplicación esta lanzada.
![ejecucion](https://github.com/Arquisoft/inci_e2a/blob/master/readme_imagenes/Ejecucion_Agents.png)

<a name="DatosEntrada"></a>
### Servicio Web ###
Para comprobar su correcto funcionamiento abriremos un navegador web y visitaremos la siguiente url:

[http://localhost:8070](http://localhost:8070)

Lo que nos debería llevar a una pagina web con el siguiente aspecto.
![funcionamiento](https://github.com/Arquisoft/inci_e2a/blob/master/readme_imagenes/Funcionamiento_Agents.png)
Para probar como se ve por dentro, rellenaremos los campos de la siguiente forma:
- Usuario: Pepe
- Contraseña: 123456
- Tipo de Usuario: Entity

### Servicio REST ###
Para comprobar esta funcionalidad es necesario enviar una petición POST a la aplicación por lo que, para este ejemplo, utilizaremos la aplicación de Google Chrome [Advance REST Client]( https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo?hl=es).
Una vez dentro de la aplicación rellenamos los datos como en la imagen:
- Method: POST
- Url: http://localhost:8070/info
- Body:
    - Content type: application/json
    - Contenido:
```{"login":"login_usuario", "password":"contraseña_usuario", "kind":"tipo_usuario"}```

Para este ejemplo usaremos los siguientes datos:
- login_usuario: Pepe
- contraseña_usuario: 123456
- tipo_usuario: Entity
![funcionamiento](https://github.com/Arquisoft/inci_e2a/blob/master/readme_imagenes/Funcionamiento_Agents_2.png)

Una vez rellenados todos los campos enviamos la petición. La aplicación nos puede devolver los siguientes códigos de estado:
1.	Código de Estado: 200 Ok. Si los datos son correctos se devolverá este código además de un JSON similar al de la imagen
![funcionamiento](https://github.com/Arquisoft/inci_e2a/blob/master/readme_imagenes/Funcionamiento_Agents_3.png)

2.	Código de Estado: 404 NOT_FOUND. Si los datos del usuario no son correctos se devolverá este código de error.
![funcionamiento](https://github.com/Arquisoft/inci_e2a/blob/master/readme_imagenes/Funcionamiento_Agents_4.png)

3.	Código de Estado: 406 NOT_ACCEPTABLE. Si falta algún campo en la petición se devolverá este código de error.
![funcionamiento](https://github.com/Arquisoft/inci_e2a/blob/master/readme_imagenes/Funcionamiento_Agents_5.png)

4.	Código de Estado: 400 BAD_REQUEST. Si el formato de la petición es incorrecto se devolverá este código de error.
![funcionamiento](https://github.com/Arquisoft/inci_e2a/blob/master/readme_imagenes/Funcionamiento_Agents_6.png)
