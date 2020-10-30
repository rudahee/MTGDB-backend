# Magic The Gathering Database: BACKEND

## Indice

1. **[Introduccion al proyecto](#introduccion-al-proyecto)**
2. **[Requisitos](#requisitos)**
3. **[Instalacion y configuracion del entorno](#instalacion-y-configuracion-del-entorno)**
4. **[Usando la API REST](#usando-a-api-rest)**
5. **[Uso de scripts](#uso-de-scripts)**
    * **Automatizacion de la instalacion del entorno**
    * **Insertando datos en masa**
6. **[Conclusiones](#conclusiones)**

----

## Introduccion al proyecto

Este proyecto se presenta a la asignatura **Integracion FRONTEND y BACKEND**. 

* Objetivo del proyecto: 
    
    Usando los conocimientos adquiridos hasta la fecha: realizar una API REST y consumirla desde un [fronted que se puede encontrar aqui.](#) 

* Objetivo de la aplicacion:

    Trata de almacenar y tratar los datos sobre un juego de cartas coleccionables (Magic The Gathering).

## Requisitos

- Java 14
- Spring Tool Suite, o en su defecto un servidor web
- MySQL (Preferentemente en Docker)


## Instalacion y configuracion del entorno

Voy a hacer el proceso de instalacion solo para distribuciones Linux basadas en Arch Linux y Debian. 

Obviare la instalacion de Spring Tool Suite. Solo hay que importar el proyecto, y ejecutarlo.

- **Instalar JAVA**

```sh
# Arch Linux
$ sudo pacman -S jdk-openjdk

# Debian
$ sudo apt install openjdk-14-jdk
```

- **Instalar Docker**

```sh
# Arch Linux
$ sudo pacman -S docker

# Debian
$ sudo apt install snapd
$ sudo snap install docker
```

- **Montar y configurar MySQL sobre Docker**
```sh
#Terminal
$ sudo docker run --name mysqldb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql:8.0

$ sudo docker exec -it mysql -uroot -p123456
```

```sql
mysql> create database db_exampleName; 

mysql> create user 'ruben'@'%' identified by '123456'; 

mysql> grant all on db_mtg.* to 'ruben'@'%'; 

```

 ## Usando la API REST

Aunque desde el frontend solo se explota una entidad, existe un crud para cada una de las entidades. Solo voy a explicar la entidad Card.

### GET

- **localhost:8081/mtgdb/card**
	- Devuelve todos las cartas.

- **localhost:8081/mtgdb/card/ID**
    - Devuelve una carta por id

### POST
- **localhost:8081/mtgdb/card**
    - Inserta una carta en formato JSON en el body.
   
- **localhost:8081/mtgdb/cards**
    - Inserta una lista de cartas en formato JSON en el body.

### PUT

- **localhost:8081/mtgdb/card/id**
    - Recibe un body en formato JSON y cambia una carta existente por id

### DELETE
- **localhost:8081/mtgdb/card/id**
    - Borra una carta existente por id

## Uso de scripts

En la carpeta Script del proyecto, se encuentra un archivo `carta.json` y el archivo `_IntroducirDatos.sh`.

Para usarlo solo se debe hacer `sh _IntroducirDatos.sh` desde una terminal ubicada en la propia carpeta del script.

Este script introducirá varias cartas en la aplicacion para poder probar el frontend con datos ya existentes.

**Hay que ejecutarlo con la base de datos encendida y la aplicacion levantada.**

## Conclusiones

Lo primero que tengo que aclarar en la parte de backend, es que para el frontend que he realizado, sobran varias entidades, con sus respectivos repositorios y controladores que son completamente accesibles sin problemas. Pero no son utiles en esta actividad.

Otra cosa que debo aclarar es que he dedicado demasiado tiempo a backend para desarrollar cosas que no he acabado usando **debido a no prestar suficiente atencion al enunciado**.

Como conclusion final, he comprendido como debo tratar los datos que se me envian y asi como he afianzado el temario visto durante las semanas anteriores, aunque existe mucho margen de mejora, espero, poco a poco ir actualizando y mejorando este repositorio tras la entrega del ejercicio.

